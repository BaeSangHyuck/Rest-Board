package com.callbus.controller;

import com.callbus.domain.repository.ReplyRepository;
import com.callbus.domain.vo.*;
import com.callbus.service.BoardService;
import com.callbus.service.ReplyService;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
    private final ReplyService replyService;

    //    게시글 댓글 전체 조회
    @GetMapping("/list/{boardNum}")
    public List<ReplyVO> getList(@PathVariable("boardNum") Long boardNum) {
        return replyService.getList(boardNum);
    }

    //    댓글 1개 조회
    @GetMapping("/{replyNum}")
    public ReplyVO read(@PathVariable("replyNum") Long replyNum){
        return replyService.getReply(replyNum);
    }

    @PostMapping("/register/{boardNum}")
    public ReplyVO insertReply(@RequestHeader(value = "Authorization") String authorization, ReplyVO replyVO,@PathVariable("boardNum") Long boardNum){
        return replyService.register(replyVO,boardNum,authorization);
    }


    @PutMapping("/{boardNum}/{replyNum}")
    public ReplyVO updateReply(ReplyVO replyVO, @PathVariable("boardNum")Long boardNum){
        return replyService.update(replyVO,boardNum);
    }

    @DeleteMapping("/{replyNum}")
    public void deleteReply(@PathVariable("replyNum") Long replyNum){
        replyService.remove(replyNum);
    }

}
