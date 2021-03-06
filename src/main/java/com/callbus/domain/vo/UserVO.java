package com.callbus.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@ToString(exclude = {"boardList","replyList","likeList"})
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "quit")
    private String quit;

    @OneToMany(mappedBy = "userVO")
    private List<BoardVO> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "userVO")
    private List<ReplyVO> replyList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id")
    @JsonIgnore
    private List<BoardLikeVO> likeList = new ArrayList<>();


    public UserVO transform(UserVO userVO) {
        String accountType;
        switch (userVO.getAccountType()) {
            case "Lessee":
                accountType = "임차인";
                break;
            case "Lessor":
                accountType = "임대인";
                break;
            default:
                accountType = "공인중개사";
                break;
        }
        userVO.setAccountType(accountType);
        return userVO;
    }

}
