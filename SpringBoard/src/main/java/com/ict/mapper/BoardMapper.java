package com.ict.mapper;

import java.util.List;

import com.ict.vo.BoardVO;

public interface BoardMapper {
	
	//@Select
	 public List<BoardVO> getList();
	 public void insertBoard(BoardVO vo);
	 public BoardVO getboard(long bno);
	 public void delBoard(long bno);
}
