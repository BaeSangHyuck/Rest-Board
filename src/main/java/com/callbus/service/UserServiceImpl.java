package com.callbus.service;

import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserVO joinUser(UserVO userVO) {
        return userRepository.save(userVO);
    }

    @Override
    public UserVO loginUser(String accountId) {
        return userRepository.findByAccountId(accountId);
    }

    public UserVO getUser(String authorization) {
        String type = authorization.split(" ")[0];
        String id = authorization.split(" " )[1];
        UserVO userVO = userRepository.findByAccountId(id);
        return userVO;
    }
}
