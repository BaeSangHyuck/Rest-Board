package com.callbus.service;

import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.UserVO;
import com.callbus.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserVO getUser(String authorization) {
        Long id = Long.valueOf(authorization.split(" " )[1]);
        UserVO userVO = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userVO;
    }
}
