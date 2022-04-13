package com.ict.service;

import java.util.List;

import com.ict.vo.BoardVO;
import com.ict.vo.Criteria;
import com.ict.vo.SearchCriteria;

// 구현클래스 BoardServiceImpl의 뼈대가 됩니다.
public interface BoardService {

		// 인터페이스 내부에 먼저 메서드를 선언하고, impl 클래스에서 구현합니다.
	public List<BoardVO> getList(SearchCriteria cri);
	public void insertBoard(BoardVO vo);
	public BoardVO getboard(long bno);
	public void delBoard(long bno);
	public void upDateBoard(BoardVO vo);
	public int countPageNum();
	public String searchStay(String searchType, String keyword);
}
