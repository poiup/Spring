package com.ict.mapper;

import java.util.List;

import com.ict.vo.BoardVO;

public interface BoardMapper {
	
	//@Select
	 public List<BoardVO> getList();
	 public void insertTbl();
}
