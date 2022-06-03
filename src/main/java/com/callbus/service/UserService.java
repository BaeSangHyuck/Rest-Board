package com.callbus.service;

import com.callbus.domain.repository.UserRepository;
import com.callbus.domain.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserVO getUser(String authorization);
}
