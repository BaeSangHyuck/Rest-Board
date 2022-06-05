package com.callbus.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_board")
@Getter
@Setter
@ToString(exclude = {"userVO","likeList","replyList"})
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private Long boardNum;
    @Column(name = "board_title")
    private String boardTitle;
    @Column(name = "board_content")
    private String boardContent;
    @Column(name = "board_write_time")
    private String boardWriteTime;
    @Column(name = "board_update_time")
    private String boardUpdateTime;
    @Column(name = "board_delete_time")
    private String boardDeleteTime;
    @Column(name = "delete_status")
    private String deleteStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "id")
    private UserVO userVO;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "board_num")
    private List<BoardLikeVO> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "boardVO",cascade = CascadeType.ALL)
    private List<ReplyVO> replyList = new ArrayList<>();


    public void update(BoardDTO boardDTO) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh");
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardUpdateTime = sdf.format(date);
    }

    public void delete() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh");
        this.deleteStatus="1";
        this.boardDeleteTime = sdf.format(date);
    }

    public void register(BoardDTO boardDTO) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh");
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardWriteTime = sdf.format(date);
        this.userVO=boardDTO.getUserVO();
    }

}
