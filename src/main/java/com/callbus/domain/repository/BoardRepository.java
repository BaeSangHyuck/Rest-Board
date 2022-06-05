package com.callbus.domain.repository;

import com.callbus.domain.vo.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardVO,Long> {
}
