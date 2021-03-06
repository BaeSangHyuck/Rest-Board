package com.callbus.domain.repository;

import com.callbus.domain.vo.BoardVO;
import com.callbus.domain.vo.ReplyVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyVO,Long> {
    List<ReplyVO> findAllByBoardVO(BoardVO boardVO);
    Long countByBoardVO(BoardVO boardVO);
}
