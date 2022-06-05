package com.callbus.controller;

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

@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("게시글 작성 테스트")
    void register() throws Exception {

        // given
        String authorization = "Lessor 1";
        String boardContent = "게시글 테스트";
        String boardTitle = "테스트 내용입니다";

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.post("/board/register")
                        .header("Authorization", authorization).param("boardTitle",boardTitle).param("boardContent",boardContent)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("게시글 조회 테스트")
    void getDetail() throws Exception {

        // given
        String authorization = "Lessor 1";
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.get("/board/" + boardNum)
                        .header("Authorization", authorization)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.boardTitle").value("제목"));
    }

    @Test
    @DisplayName("게시글 리스트 테스트")
    void getList() throws Exception {

        // given
        String authorization = "Lessor 1";

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.get("/board/boardList")
                        .header("Authorization", authorization)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }


    @Test
    @DisplayName("게시글 변경 테스트")
    void update() throws Exception {

        // given
        String authorization = "Lessor 1";
        String boardContent = "게시글 변경 테스트";
        String boardTitle = "변경 테스트 내용입니다";
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.put("/board/"+boardNum)
                        .header("Authorization", authorization).param("boardTitle",boardTitle).param("boardContent",boardContent)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void delete() throws Exception {

        // given
        String authorization = "Lessor 1";
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.delete("/board/"+boardNum)
                        .header("Authorization", authorization)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("게시글 좋아요 테스트")
    void like() throws Exception {

        // given
        String authorization = "Lessor 1";
        Long boardNum = 1L;

        // when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.put("/board/like/"+boardNum)
                        .header("Authorization", authorization)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print());
    }


}
