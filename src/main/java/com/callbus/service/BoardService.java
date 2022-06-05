package com.callbus.service;

import com.callbus.domain.repository.BoardLikeRepository;
import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.repository.ReplyRepository;
import com.callbus.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final ReplyRepository replyRepository;
    private final UserService userService;

    public List<BoardDTO> getList(Long userId) {
        List<BoardDTO> boardList = new ArrayList<>();
        List<BoardVO> boards = boardRepository.findAll();
        for (int i = 0; i < boards.size(); i++) {
            UserVO userVO = new UserVO().transform(boards.get(i).getUserVO());
            boards.get(i).setUserVO(userVO);
            BoardDTO boardDTO = new BoardDTO().transform(boards.get(i));
            boardList.add(setBoardInfo(boardDTO,userId,boardDTO.getBoardNum()));
        }
        return boardList;
    }

    public BoardVO register(BoardDTO boardDTO, String authorization) {
        boardDTO.setUserVO(userService.getUser(authorization));
        BoardVO boardVO= new BoardVO();
        boardVO.register(boardDTO);
        return boardRepository.save(boardVO);
    }

    @Transactional
    public BoardVO remove(Long boardNum) {
        //삭제시 삭제시간 입력 및 상태표시 1로 변경(1은 삭제, 0은 기본)
        BoardVO boardVO = boardRepository.findById(boardNum).orElseThrow();
        boardVO.delete(boardNum);
        return boardVO;
    }

    @Transactional
    public BoardVO update(BoardDTO boardDTO, Long boardNum) {
        BoardVO boardVO = boardRepository.findById(boardNum).orElseThrow();
        boardVO.update(boardDTO); // 변경감지

        return boardVO;
    }

    public BoardDTO getDetail(Long userId, Long boardNum) {
        BoardDTO boardDTO = new BoardDTO().transform(boardRepository.getById(boardNum));
        return setBoardInfo(boardDTO,userId,boardNum);
    }


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

    public BoardVO getBoard(Long boardNum) {
        return boardRepository.getById(boardNum);
    }


    public BoardDTO setBoardInfo(BoardDTO boardDTO, Long userId, Long boardNum) {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardNum(boardNum);
        boardDTO.setReplyCount(replyRepository.countByBoardVO(boardVO));
        boardDTO.setLikeCount(boardLikeRepository.countByBoardNum(boardNum));
        boardDTO.setLiked(boardLikeRepository.existsByIdAndBoardNum(userId,boardNum));
        return boardDTO;
    }
}
