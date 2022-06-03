package com.callbus.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_board_like")
@Getter
@ToString
@NoArgsConstructor
@IdClass(BoardLikeID.class)
public class BoardLikeVO{
    @Id
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "board_num")
    private Long boardNum;

    @Builder
    public BoardLikeVO(Long id, Long boardNum) {
        this.id = id;
        this.boardNum = boardNum;
    }
}