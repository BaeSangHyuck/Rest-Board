package com.callbus.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nickname;
    private String accountType;
    private String accountId;
    private String quit;


    public UserDTO(Long id, String nickname, String accountType, String accountId, String quit) {
        this.id = id;
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
        this.quit = quit;
    }

}
