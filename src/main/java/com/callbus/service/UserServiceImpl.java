package com.callbus.service;

import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserVO getUser(String authorization) {
        String type = authorization.split(" ")[0];
        String id = authorization.split(" " )[1];
        UserVO userVO = userRepository.findByAccountId(id);
        return userVO;
    }
}
