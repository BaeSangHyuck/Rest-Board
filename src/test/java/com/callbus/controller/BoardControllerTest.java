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
    @DisplayName("보드 조회 테스트")
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


}
