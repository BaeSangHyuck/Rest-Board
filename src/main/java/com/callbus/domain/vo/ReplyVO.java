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
@AllArgsConstructor
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

    public void update(ReplyDTO replyDTO){
        this.replyContent=replyDTO.getReplyContent();
        this.replyNum=replyDTO.getReplyNum();
        this.boardVO=replyDTO.getBoardVO();
        this.userVO=replyDTO.getUserVO();
    }

    public void register(ReplyDTO replyDTO){
        this.replyContent=replyDTO.getReplyContent();
        this.boardVO=replyDTO.getBoardVO();
        this.userVO=replyDTO.getUserVO();
    }
}
