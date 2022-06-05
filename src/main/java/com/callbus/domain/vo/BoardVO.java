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

    @Builder
    public BoardVO(Long boardNum, String boardTitle, String boardContent, String boardWriteTime, String boardUpdateTime, String boardDeleteTime, String deleteStatus, UserVO userVO) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteTime = boardWriteTime;
        this.boardUpdateTime = boardUpdateTime;
        this.boardDeleteTime = boardDeleteTime;
        this.deleteStatus = deleteStatus;
        this.userVO = userVO;
    }

    public void update(BoardDTO boardDTO) {
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardUpdateTime = boardDTO.getBoardUpdateTime();
    }

}
