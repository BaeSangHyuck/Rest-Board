package com.callbus.controller;

import com.callbus.domain.vo.BoardVO;
import com.callbus.domain.vo.UserVO;
import com.callbus.service.BoardService;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final UserService userService;
    private final BoardService boardService;

    @GetMapping("/board")
    public void getList(@RequestHeader String authorization) {
        UserVO user = userService.getUser(authorization);
        if(Objects.isNull(user)){
            user.setAccountType("visitor");
        }

    }

    @GetMapping("/board/write")
    public String openBoardWrite(){
        return "/board/restBoardWrite";
    }

    @PostMapping("/board/write")
    public String insertBoard(BoardVO boardVO){
        boardService.register(boardVO);
        return "redirect:/board";
    }

    @GetMapping("/board/{boardNum}")
    public ModelAndView openBoardDetail(@PathVariable("boardNum") Long boardNum){
        ModelAndView mv = new ModelAndView("/boardDetail");
        return mv;
    }

    @PutMapping("/board/{boardNum}")
    public String updateBoard(BoardVO boardVO){
        return "redirect:/board";
    }

    @DeleteMapping("/board/{boardNum}")
    public String deleteBoard(@PathVariable("boardNum") Long boardNum){
        return "redirect:/board";
    }

}
