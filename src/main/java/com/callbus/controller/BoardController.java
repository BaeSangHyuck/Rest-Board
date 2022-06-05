package com.callbus.controller;

import com.callbus.domain.vo.*;
import com.callbus.service.BoardService;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final UserService userService;
    private final BoardService boardService;

    @GetMapping("/boardList")
    public List<BoardDTO> getBoardList(@RequestHeader(value = "Authorization") String authorization) {
        return boardService.getList(userService.getUser(authorization).getId());
    }

    @PostMapping("/register")
    public BoardVO insertBoard(BoardDTO boardDTO, @RequestHeader(value = "Authorization") String authorization){
        return boardService.register(boardDTO,authorization);
    }

    @GetMapping("/{boardNum}")
    public BoardDTO getBoardDetail(@RequestHeader(value = "Authorization") String authorization, @PathVariable("boardNum") Long boardNum) {
        return boardService.getDetail(userService.getUser(authorization).getId(),boardNum);
    }

    @PutMapping("/{boardNum}")
    public BoardVO updateBoard(BoardDTO boardDTO, @PathVariable("boardNum")Long boardNum){
        return boardService.update(boardDTO, boardNum);
    }

    @DeleteMapping("/{boardNum}")
    public BoardVO deleteBoard(@PathVariable("boardNum") Long boardNum) {
        return boardService.remove(boardNum);
    }

    @PutMapping("like/{boardNum}")
    public boolean likeBoard(@RequestHeader(value = "Authorization") String authorization, @PathVariable("boardNum") Long boardNum) {
        //리턴 벨류 true = 좋아요, false = 좋아요 취소
        return boardService.likeBoard(userService.getUser(authorization).getId(),boardNum);
    }

}
