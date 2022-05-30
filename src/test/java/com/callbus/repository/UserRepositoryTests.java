package com.callbus.repository;

import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void insertTest(){
//        userRepository.save(UserVO.builder().accountId("testId").id(2L).nickname("test").accountType("Lessor").build());
//    }

//    @Test
//    public void testGetUserList(){
//        List<UserVO> userList = userRepository.findAll();
//        userList.stream().map(u->u.toString()).forEach(log::info);
//    }
//    @Test
//    public void testGetUserInfo(){
//        UserVO userVO = userRepository.findById(1L).get();
//        log.info(userVO.toString());
//    }
//    @Test
//    public void testGetUserInfoByUserId(){
//        UserVO userVO=userRepository.findByAccountId("tkdgur1996");
//        log.info(userVO.toString());
//    }
}
