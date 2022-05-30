package com.callbus.service;

import com.callbus.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public List<BoardVO> getList();
}
