package com.callbus.service;

import com.callbus.domain.vo.UserVO;
import com.callbus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class UserServiceTests {
    @Autowired
    private UserService userService;

//    @Test
//    @Transactional
//    public void getUserTest(){
//        UserVO user = userService.getUser("Lessor 1");
//        log.info(user.toString());
//    }
}
