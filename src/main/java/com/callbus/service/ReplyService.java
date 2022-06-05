package com.callbus.service;

import com.callbus.domain.vo.ReplyVO;
import com.callbus.domain.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    public List<ReplyVO> getList(Long boardNum);
    public ReplyVO getReply(Long replyNum);
    public void remove(Long replyNum);
    public ReplyVO update(ReplyVO replyVO,Long boardNum);
    public ReplyVO register(ReplyVO replyVO,Long boardNum,String authorization);
}
