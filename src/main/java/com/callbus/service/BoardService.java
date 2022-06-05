package com.callbus.service;

import com.callbus.domain.vo.BoardDTO;
import com.callbus.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
   List<BoardDTO> getList(Long id);
   BoardVO register(BoardVO boardVO,String authorization);
   BoardVO remove(Long boardNum);
   BoardVO update(BoardDTO boardDTO, Long boardNum);
   BoardDTO getDetail(Long id, Long boardNum);
   BoardDTO setBoardInfo(BoardDTO boardDTO, Long id, Long boardNum);
   boolean likeBoard (Long id, Long boardNum);
   BoardVO getBoard(Long boardNum);

}
