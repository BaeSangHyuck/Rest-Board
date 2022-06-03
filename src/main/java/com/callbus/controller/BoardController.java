package com.callbus.controller;

import com.callbus.domain.vo.BoardDTO;
import com.callbus.domain.vo.BoardVO;
import com.callbus.domain.vo.UserDTO;
import com.callbus.domain.vo.UserVO;
import com.callbus.service.BoardService;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
    public String getList(@RequestHeader String authorization, Model model) {
        UserVO userVO = userService.getUser(authorization);
        if(!Objects.isNull(userVO)){
            UserDTO user = new UserDTO().transform(userVO);
            user.setWriteable(true);
            model.addAttribute(user);
        }
        return "/boardList";
    }

    @GetMapping("/boardList")
    public List<BoardDTO> getList() {
        List<BoardDTO>boardList = new BoardDTO().transform(boardService.getList());
        return boardList;
    }

    @GetMapping("/write")
    public String openBoardWrite(){
        return "/board/restBoardWrite";
    }

    @PostMapping("/write")
    public String insertBoard(BoardVO boardVO){
        boardService.register(boardVO);
        return "redirect:/board";
    }

    @GetMapping("/{boardNum}")
    public ModelAndView openBoardDetail(@PathVariable("boardNum") Long boardNum){
        ModelAndView mv = new ModelAndView("/boardDetail");
        return mv;
    }

    @PutMapping("/{boardNum}")
    public String updateBoard(BoardVO boardVO){
        return "redirect:/board";
    }

    @DeleteMapping("/{boardNum}")
    public String deleteBoard(@PathVariable("boardNum") Long boardNum){
        return "redirect:/board";
    }

}
