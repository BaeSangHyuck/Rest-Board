package com.callbus.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Component
@NoArgsConstructor
public class BoardLikeID implements Serializable {

    @Column(name = "id")
    private Long id;
    @Column(name = "board_num")
    private Long board_num;

    public BoardLikeID(Long id, Long board_num) {
        this.id = id;
        this.board_num = board_num;
    }
}
