package com.callbus.domain.vo;

import lombok.AllArgsConstructor;
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
    private UserVO userVO;

    public BoardDTO(Long boardNum, String boardTitle, String boardContent, String boardWriteTime, String boardUpdateTime, String boardDeleteTime, String deleteStatus,UserVO userVO) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteTime = boardWriteTime;
        this.boardUpdateTime = boardUpdateTime;
        this.boardDeleteTime = boardDeleteTime;
        this.deleteStatus = deleteStatus;
        this.likeCount = 0L;
        this.liked = false;
        this.userVO = userVO;
    }

    public List<BoardDTO> transform(List<BoardVO> boardVOS) {
        List<BoardDTO> boardList = new ArrayList<>();
        for (int i=0; i<boardVOS.size();i++){
            BoardDTO boardDTO = new BoardDTO(boardVOS.get(i).getBoardNum(),boardVOS.get(i).getBoardTitle(),boardVOS.get(i).getBoardContent(),
                    boardVOS.get(i).getBoardWriteTime(),boardVOS.get(i).getBoardUpdateTime(),boardVOS.get(i).getBoardDeleteTime(),boardVOS.get(i).getDeleteStatus(),boardVOS.get(i).getUserVO());
            boardList.add(boardDTO);
        }
        return boardList;
    }
}
