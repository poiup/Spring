package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ict.mapper.BoardMapper;
import com.ict.mapper.ReplyMapper;
import com.ict.vo.BoardVO;
import com.ict.vo.SearchCriteria;

@Service // bean 컨테이너에 등록
public class BoardServiceImpl implements BoardService {

	// 서비스가 DAO(Mapper.java)를 호출한다면 선언을 하고 의존성주입을 해야합니다.
	// 해당 코드를 작성해주세요.(BoardController.java를 참고하세요
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<BoardVO> getList(SearchCriteria cri) {
		return boardMapper.getList(cri);
	}

	@Override
	public int countPageNum(SearchCriteria cri) {
		return boardMapper.countPageNum(cri);
	}

	@Override
	public BoardVO getboard(long bno) {
		return boardMapper.getboard(bno);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardMapper.insertBoard(vo);
	}
	
	@Transactional
	@Override
	public void delBoard(Long bno) {
		boardMapper.delBoard(bno);	
		replyMapper.delAllReplies(bno);
	}

	@Override
	public void upDateBoard(BoardVO vo) {
		boardMapper.upDateBoard(vo);
	}

	@Override
	public String searchStay(String searchType, String keyword) {
		if(!searchType.equals(null)) {
			searchType = "&searchType="+searchType;
		}
		if(!keyword.equals(null)) {
			keyword = "&keyword="+keyword;
		} 
		return searchType+keyword;
	}


	
	// 리턴자료형이 없는 insert, delete, update 구문은 사용자 행동 기준으로 메서드를 나눕니다.
	// 리턴자료형이 있는 select구문은 하나의 메서드가 하나의 쿼리문을 담당합니다.
}
