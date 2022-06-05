package com.callbus.service;

import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.repository.ReplyRepository;
import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.BoardLikeID;
import com.callbus.domain.vo.ReplyDTO;
import com.callbus.domain.vo.ReplyVO;
import com.callbus.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<ReplyVO> getList(Long boardNum) {
        return replyRepository.findAllByBoardVO(boardService.getBoard(boardNum));
    }

    @Transactional
    public void remove(Long replyNum) {
        ReplyVO replyVO = replyRepository.findById(replyNum).orElseThrow();
        replyVO.setUserVO(null);
        replyVO.setBoardVO(null);
        replyRepository.delete(replyVO);
    }

    @Transactional
    public ReplyVO update(ReplyDTO replyDTO,String authorization, Long boardNum,Long replyNum) {
        ReplyVO replyVO = replyRepository.findById(replyNum).orElseThrow();
        replyVO.update(replyDTO);
        replyVO.setBoardVO(boardRepository.findById(boardNum).orElseThrow());
        replyVO.setUserVO(userService.getUser(authorization));
        return replyVO;
    }

    @Transactional
    public ReplyVO register(ReplyDTO replyDTO,Long boardNum,String authorization) {
        ReplyVO replyVO = new ReplyVO();
        replyVO.register(replyDTO);
        replyVO.setUserVO(userService.getUser(authorization));
        replyVO.setBoardVO(boardRepository.getById(boardNum));
        return replyRepository.save(replyVO);
    }


}
