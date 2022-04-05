package com.ict.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTest {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void getList() {
		log.info(boardMapper.getList());
	} 
	
	@Test
	public void insertTbl() {
		boardMapper.insertTbl();
		log.info(boardMapper.getList());
	}
}
