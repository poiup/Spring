package com.ict.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.time.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	// 인터페이스를 호출하려면 구현 클래스화 해야함
	// @Autowired를 하면 자동으로 마이바티스가 구현해줌
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("현재 시간 조회중...");
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("현재시각 조회중....");
		log.info(timeMapper.getTime2());
	}
}
