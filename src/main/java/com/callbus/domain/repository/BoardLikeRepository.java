package com.callbus.domain.repository;

import com.callbus.domain.vo.BoardLikeVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLikeVO,Long> {
    public BoardLikeVO countByBoardNum(Long boardNum);
}
