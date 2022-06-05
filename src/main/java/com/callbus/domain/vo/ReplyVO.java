package com.callbus.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "tbl_reply")
@Getter
@Setter
@ToString(exclude = {"userVO","boardVO"})
@NoArgsConstructor
@DynamicInsert
public class ReplyVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_num")
    private Long replyNum;

    @Column(name = "reply_content")
    private String replyContent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "id")
    private UserVO userVO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="board_num")
    private BoardVO boardVO;

    @Builder
    public ReplyVO(String replyContent, UserVO userVO, BoardVO boardVO) {
        this.replyContent = replyContent;
        this.userVO = userVO;
        this.boardVO = boardVO;
    }
}
