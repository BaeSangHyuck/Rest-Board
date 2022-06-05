package com.callbus.service;

import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.repository.ReplyRepository;
import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.ReplyVO;
import com.callbus.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;
    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final UserService userService;

    @Override
    public List<ReplyVO> getList(Long boardNum) {
        return replyRepository.findAllByBoardVO(boardService.getBoard(boardNum));
    }

    @Override
    public ReplyVO getReply(Long replyNum) {
        return replyRepository.getById(replyNum);
    }

    @Override
    public void remove(Long replyNum) {
        replyRepository.deleteById(replyNum);
    }

    @Override
    public ReplyVO update(ReplyVO replyVO,Long boardNum) {
        replyVO.setBoardVO(boardRepository.findById(boardNum).get());
        return replyRepository.save(replyVO);
    }

    @Override
    @Transactional
    public ReplyVO register(ReplyVO replyVO,Long boardNum,String authorization) {
        replyVO.setUserVO(userService.getUser(authorization));
        replyVO.setBoardVO(boardRepository.getById(boardNum));
        return replyRepository.save(replyVO);
    }


}
