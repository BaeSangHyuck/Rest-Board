package com.callbus.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private Long boardNum;
    @Column(name = "board_title")
    private String board_title;
    @Column(name = "board_content")
    private String board_content;
    @Column(name = "board_write_time")
    private String board_write_time;
    @Column(name = "board_update_time")
    private String board_update_time;
    @Column(name = "board_delete_time")
    private String board_delete_time;
    @Column(name = "delete_status")
    private String deleteStatus;


    @ManyToOne
    @JoinColumn(name = "id")
    private UserVO userVO;

    @OneToMany(mappedBy = "boardVO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardLikeVO> likeList = new ArrayList<>();

    
}
