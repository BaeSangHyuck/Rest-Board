package com.callbus.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long boardNum;
    private String boardTitle;
    private String boardContent;
    private String boardWriteTime;
    private String boardUpdateTime;
    private String boardDeleteTime;
    private String deleteStatus;
    private Long likeCount;
    private boolean liked;
    private Long replyCount;
    private UserVO userVO;

    @Builder
    public BoardDTO(Long boardNum, String boardTitle, String boardContent, String boardWriteTime, String boardUpdateTime, String boardDeleteTime, String deleteStatus, UserVO userVO) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteTime = boardWriteTime;
        this.boardUpdateTime = boardUpdateTime;
        this.boardDeleteTime = boardDeleteTime;
        this.deleteStatus = deleteStatus;
        this.likeCount = 0L;
        this.replyCount = 0L;
        this.liked = false;
        this.userVO = userVO;
    }

    public BoardDTO transform(BoardVO boardVO) {
        BoardDTO boardDTO = BoardDTO.builder().boardNum(boardVO.getBoardNum()).boardTitle(boardVO.getBoardTitle()).boardContent(boardVO.getBoardContent()).
                boardWriteTime(boardVO.getBoardWriteTime()).boardDeleteTime(boardVO.getBoardDeleteTime()).boardUpdateTime(boardVO.getBoardUpdateTime()).
                deleteStatus(boardVO.getDeleteStatus()).build();
        return boardDTO;
    }
}
