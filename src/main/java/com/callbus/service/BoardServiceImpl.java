package com.callbus.service;

import com.callbus.domain.repository.BoardLikeRepository;
import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.repository.ReplyRepository;
import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.BoardDTO;
import com.callbus.domain.vo.BoardLikeVO;
import com.callbus.domain.vo.BoardVO;
import com.callbus.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final ReplyRepository replyRepository;
    private final UserService userService;

    @Override
    public List<BoardDTO> getList(Long id) {
        List<BoardDTO> boardList = new ArrayList<>();
        List<BoardVO> boards = boardRepository.findAll();
        for (int i = 0; i < boards.size(); i++) {
            UserVO userVO = new UserVO();
            switch (boards.get(i).getUserVO().getAccountType()){
                case "Lessee" :
                    userVO.setAccountType("임차인");
                    break;
                case "Lessor" :
                    userVO.setAccountType("임대인");
                    break;
                default:
                    userVO.setAccountType("공인중개사");
                    break;
            }
            boards.get(i).setUserVO(userVO);
            BoardDTO boardDTO = new BoardDTO().transform(boards.get(i));
            boardList.add(setBoardInfo(boardDTO,id,boardDTO.getBoardNum()));
        }
        return boardList;
    }

    @Override
    //작성 시 default로 작성시간이 현재시간으로 입력
    public BoardVO register(BoardVO boardVO, String authorization) {
        boardVO.setUserVO(userService.getUser(authorization));
        return boardRepository.save(boardVO);
    }

    @Override
    public BoardVO remove(Long boardNum) {
        //삭제시 삭제시간 입력 및 상태표시 1로 변경(1은 삭제, 0은 기본)
        Date deleteTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh");
        BoardVO boardVO= boardRepository.findById(boardNum).get();
        boardVO.setBoardDeleteTime(sdf.format(deleteTime));
        boardVO.setDeleteStatus("1");
        return boardRepository.save(boardVO);
    }

    @Override
    @Transactional
    public BoardVO update(BoardDTO boardDTO, Long boardNum) {

        BoardVO boardVO = boardRepository.findById(boardNum).orElseThrow();
        boardVO.update(boardDTO); // 변경감지

        return boardVO;
    }

    @Override
    public BoardDTO getDetail(Long id, Long boardNum) {
        BoardDTO boardDTO = new BoardDTO().transform(boardRepository.getById(boardNum));
        return setBoardInfo(boardDTO,id,boardNum);
    }



    @Override
    public boolean likeBoard(Long userId, Long boardNum) {
        boolean check = boardLikeRepository.existsByIdAndBoardNum(userId,boardNum);
        BoardLikeVO boardLikeVO = new BoardLikeVO(userId,boardNum);

        if(check){
            boardLikeRepository.delete(boardLikeVO);
            return false;
        }

        boardLikeRepository.save(boardLikeVO);
        return true;
    }

    @Override
    public BoardVO getBoard(Long boardNum) {
        return boardRepository.getById(boardNum);
    }

    @Override
    public BoardDTO setBoardInfo(BoardDTO boardDTO, Long id, Long boardNum) {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardNum(boardNum);
        boardDTO.setReplyCount(replyRepository.countByBoardVO(boardVO));
        boardDTO.setLikeCount(boardLikeRepository.countByBoardNum(boardNum));
        boardDTO.setLiked(boardLikeRepository.existsByIdAndBoardNum(id,boardNum));
        return boardDTO;
    }
}
