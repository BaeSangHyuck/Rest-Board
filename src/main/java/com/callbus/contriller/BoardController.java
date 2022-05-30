package com.callbus.contriller;

import com.callbus.domain.vo.UserVO;
import com.callbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final UserService userService;

    @GetMapping("/board")
    public void getList(@RequestHeader String authorization) {
        UserVO user = userService.getUser(authorization);
        if(Objects.isNull(user)){
            user.setAccountType("visitor");
        }

    }

    @GetMapping("/board/boardDetail")
    public void boardDetail(){

    }
    @PostMapping("/board/boardRegister")
    public void boardRegister(){

    }
}
