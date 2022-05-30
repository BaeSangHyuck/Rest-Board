package com.callbus.domain.repository;

import com.callbus.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO,Long> {
    public UserVO findByAccountId(String accountId);
}
