package com.ict.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.aop.LogAdvice;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {

	@Autowired
	private SampleService service;
	@Test
	public void testClass() throws Exception {
		log.info(service);
		log.info(service.getClass().getName());
		
	}
	
	@Test
	public void teststr() throws Exception {
		log.info(service.doAdd("3", "5"));
	}
	
	
}
