package com.callbus.controller;


import com.callbus.domain.vo.UserVO;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public void join(){

    }
    @PostMapping("/join")
    public void join(UserVO userVO){
        userService.joinUser(userVO);
    }

    @GetMapping("/login")
    public void login(){

    }

    @PostMapping("/login")
    public RedirectView login(String accountId, HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserVO userVO =userService.loginUser(accountId);
        session.setAttribute("userInfo",userVO.getAccountType() +" "+userVO.getId());
        return new RedirectView("/board");
    }
}
