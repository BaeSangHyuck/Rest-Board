package com.callbus.repository;

import com.callbus.domain.repository.BoardLikeRepository;
import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.vo.BoardVO;
import com.callbus.domain.vo.UserVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@Slf4j
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardLikeRepository boardLikeRepository;

//    @Test
//    public void boardRegisterTest(){
//        BoardVO boardVO = new BoardVO();
//        UserVO userVO = new UserVO();
//        userVO.setId(1L);
//        boardVO.setUserVO(userVO);
//        boardVO.setBoardTitle("제목");
//        boardVO.setBoardContent("내용");
//        boardRepository.save(boardVO);
//    }

//    @Test
//    public void boardUpdateTest(){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
//        boardRepository.save(BoardVO.builder().boardNum(1L).boardTitle("반가워용").boardContent("안녕하세요").boardUpdateTime(String.valueOf(sdf.format(date))).build());
//    }
//
//    @Test
//    public void getCountTest(){
//        log.info(boardLikeRepository.countByBoardNum(1L).toString());
//    }

//    @Test
//    public void getLikedTest(){
//        log.info(""+boardLikeRepository.existsByIdAndBoardNum(2L,1L));
//    }

}
