package com.callbus.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long replyNum;
    private String replyContent;
    private UserVO userVO;
    private BoardVO boardVO;


}
