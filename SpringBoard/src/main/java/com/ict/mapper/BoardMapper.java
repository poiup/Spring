package com.ict.mapper;

import java.util.List;

import com.ict.vo.BoardVO;
import com.ict.vo.Criteria;
import com.ict.vo.PageVO;

public interface BoardMapper {
	
	//@Select
	 public List<BoardVO> getList(Criteria vo);
	 public void insertBoard(BoardVO vo);
	 public BoardVO getboard(long bno);
	 public void delBoard(long bno);
	 public void upDateBoard(BoardVO vo);
	 public int countPageNum();
	// vo를 쓰지않고 보내기 위해서는 
	// 메서드에 변수를 넣을떄 @param(변수명)을 해줘야합니다
	// 예시public void  upDateBoard(@param("title"), @param("content"), @param("bno"));	
}
