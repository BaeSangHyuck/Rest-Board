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
    private boolean writeable;

    public UserDTO(Long id, String nickname, String accountType, String accountId, String quit) {
        this.id = id;
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
        this.quit = quit;
        this.writeable = false;
    }

    public UserDTO transform(UserVO userVO){
        String accountType;
        switch (getAccountType()){
            case "Lessee" :
                accountType="임차인";
                break;
            case "Lessor" :
                accountType="임대인";
                break;
            default:
                accountType="공인중개사";
                break;
        }
        UserDTO userDTO = new UserDTO(userVO.getId(),userVO.getNickname(),accountType,userVO.getAccountId(),userVO.getQuit());
        return userDTO;
    }
}
