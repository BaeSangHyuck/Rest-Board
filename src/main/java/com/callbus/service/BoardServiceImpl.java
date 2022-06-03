package com.callbus.service;

import com.callbus.domain.repository.BoardRepository;
import com.callbus.domain.vo.BoardDTO;
import com.callbus.domain.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public List<BoardVO> getList() {return boardRepository.findAll();}

    @Override
    public BoardVO register(BoardVO boardVO) {return boardRepository.save(boardVO);}

}
