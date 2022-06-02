package com.callbus.domain.vo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_board_like")
@Getter
@ToString(of = {"id", "boardNum"})
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BoardLikeID.class)
public class BoardLikeVO{
    @Id
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "board_num")
    private Long boardNum;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserVO userVO;

    @ManyToOne
    @JoinColumn(name = "board_num")
    private BoardVO boardVO;

    @Builder
    public BoardLikeVO(Long id, Long boardNum) {
        this.id = id;
        this.boardNum = boardNum;
    }
}