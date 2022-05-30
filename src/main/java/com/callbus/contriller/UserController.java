package com.callbus.contriller;


import com.callbus.domain.vo.UserVO;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


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
        return new RedirectView("/board/boardList");
    }
}
