package com.callbus.domain.repository;

import com.callbus.domain.vo.BoardLikeVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLikeVO,Long> {
    public Long countByBoardNum(Long boardNum);
    public boolean existsByIdAndBoardNum(Long id, Long boardNum);
}
