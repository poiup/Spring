package com.ict.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.mapper.BoardMapper;
import com.ict.vo.BoardVO;
import com.ict.vo.Criteria;
import com.ict.vo.PageVO;
import com.ict.vo.SearchCriteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTest {
	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	public void insertBoard() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("새로넣는글");
		vo.setContent("새로넣는 본문");
		vo.setWriter("새로운글쓴이");
		
		boardMapper.insertBoard(vo);
	}
	
	//@Test
	public void getList() {
		SearchCriteria vo = new SearchCriteria();
		
		vo.setSearchType("tc");
		vo.setKeyword("테스트본문");
		List<BoardVO> boardList = boardMapper.getList(vo);
		log.info(boardMapper.getList(vo));
	} 
	
	@Test
	public void getboard() {
		long bno = 311689;

		boardMapper.getboard(bno);
	}
	
	//@Test
	public void delBoard() {
		long bno = 2;
		
		boardMapper.delBoard(bno);	
	}
	
	//@Test
	public void upDateBoard() {
		BoardVO vo = new BoardVO();
		
		vo.setBno((long) 4);
		vo.setTitle("변경된 제목");
		vo.setContent("변경된 본문");
		boardMapper.upDateBoard(vo);	
	}
	
	 @Test
	public void countPageNum() {
		SearchCriteria vo = new SearchCriteria();
		// vo.setSearchType("tc");
		// vo.setKeyword("테스트본문");
		log.info(vo);
		boardMapper.countPageNum(vo);
		log.info(boardMapper.countPageNum(vo));
	}
}
