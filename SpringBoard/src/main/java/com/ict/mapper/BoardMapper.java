package com.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ict.vo.BoardVO;
import com.ict.vo.Criteria;
import com.ict.vo.PageVO;
import com.ict.vo.SearchCriteria;

public interface BoardMapper {
	
	//@Select
	 public List<BoardVO> getList(SearchCriteria vo);
	 public void insertBoard(BoardVO vo);
	 public BoardVO getboard(long bno);
	 public void delBoard(Long bno);
	 public void upDateBoard(BoardVO vo);
	 public int countPageNum(SearchCriteria vo);
	 public String searchStay();
	 public void updateReply(@Param("bno") Long bno,
			 					@Param("amount") int amount); 
	// vo를 쓰지않고 보내기 위해서는 
	// 메서드에 변수를 넣을떄 @param(변수명)을 해줘야합니다
	// 예시public void  upDateBoard(@param("title"), @param("content"), @param("bno"));	
}
