package com.ict.mapper;

import java.util.List;

import com.ict.vo.BoardAttachVO;

public interface BoardAttachMapper {
		public void insert(BoardAttachVO vo);
		public void delete(String uuid);
		public List<BoardAttachVO> findbyBno(Long bno);
}
