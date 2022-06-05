package com.callbus.controller;

import com.callbus.domain.vo.*;
import com.callbus.exception.UserNotFoundException;
import com.callbus.service.BoardService;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final UserService userService;
    private final BoardService boardService;

    //로그인 성공했을 때 로그인 정보를 가지고 리스트 페이지로 이동
    @GetMapping("")
    public String getList(@RequestHeader(value = "Authorization") String authorization, Model model)  throws Exception{
        UserVO userVO = userService.getUser(authorization);
        if(!Objects.isNull(userVO)){
            UserDTO user = new UserDTO().transform(userVO);
            user.setWriteable(true);
            model.addAttribute(user);
        }
        return "/board/boardList";
    }

    @GetMapping("/boardList")
    public List<BoardDTO> getList(@RequestHeader(value = "Authorization") String authorization) {
        return boardService.getList(userService.getUser(authorization).getId());
    }

    @PostMapping("/register")
    public BoardVO insertBoard(BoardVO boardVO, @RequestHeader(value = "Authorization") String authorization){
        return boardService.register(boardVO,authorization);
    }

    @GetMapping("/{boardNum}")
    public BoardDTO boardDetail(@RequestHeader(value = "Authorization") String authorization, @PathVariable("boardNum") Long boardNum) {
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

    @DeleteMapping("like/{boardNum}")
    public boolean likeBoard(@RequestHeader(value = "Authorization") String authorization, @PathVariable("boardNum") Long boardNum) {
        //리턴 벨류 true = 좋아요, false = 좋아요 취소
        return boardService.likeBoard(userService.getUser(authorization).getId(),boardNum);
    }

}
