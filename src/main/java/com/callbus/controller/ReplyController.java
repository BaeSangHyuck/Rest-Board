package com.callbus.controller;

import com.callbus.domain.vo.*;
import com.callbus.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/register/{boardNum}")
    public ReplyVO insertReply(@RequestHeader(value = "Authorization") String authorization, ReplyDTO replyDTO,@PathVariable("boardNum") Long boardNum){
        return replyService.register(replyDTO,boardNum,authorization);
    }


    @PutMapping("/{boardNum}/{replyNum}")
    public ReplyVO updateReply(@RequestHeader(value = "Authorization") String authorization, ReplyDTO replyDTO, @PathVariable("boardNum")Long boardNum, @PathVariable("replyNum")Long replyNum){
        return replyService.update(replyDTO,authorization,boardNum,replyNum);
    }

    @DeleteMapping("/{replyNum}")
    public void deleteReply(@PathVariable("replyNum") Long replyNum){
        replyService.remove(replyNum);
    }

}
