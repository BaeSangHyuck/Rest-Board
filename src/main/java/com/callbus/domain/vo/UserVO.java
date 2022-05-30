package com.callbus.domain.vo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@ToString(of = {"id","nickname","accountType","accountId","quit"})
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

    @OneToMany(mappedBy = "userVO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardVO> boardList = new ArrayList<>();

    @Builder
    public UserVO(Long id, String nickname,String accountId,String accountType){
        this.id=id;
        this.accountId=accountId;
        this.accountType=accountType;
        this.nickname=nickname;
    }

}
