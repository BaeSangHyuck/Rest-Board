package com.callbus.controller;

import com.callbus.domain.repository.ReplyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReplyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ReplyRepository replyRepository;

    @Test
    @DisplayName("댓글 작성 테스트")
    void register() throws Exception {

        // given
        String authorization = "Lessor 1";
        String replyContent = "댓글 작성 테스트";
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.post("/replies/register/"+boardNum)
                        .header("Authorization", authorization).param("replyContent",replyContent)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("댓글 리스트 테스트")
    void getList() throws Exception {

        // given
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.get("/replies/list/"+boardNum)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("댓글 변경 테스트")
    void updateReply() throws Exception {

        // given
        String replyContent = "댓글 변경 테스트";
        String authorization = "Lessor 1";
        Long boardNum = 1L;
        Long replyNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.put("/replies/"+boardNum+"/"+replyNum)
                        .header("Authorization", authorization).param("replyContent",replyContent));

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("댓글 삭제 테스트")
    void deleteReply() throws Exception {

        // given
        Long replyNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.delete("/replies/"+replyNum)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
        System.out.println(replyRepository.existsById(replyNum));
    }

}
