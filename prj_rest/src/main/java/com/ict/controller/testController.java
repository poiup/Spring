package com.ict.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.damain.TestVO;

@RestController
@RequestMapping("/test")
public class testController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello HEllo";
	}
	
	@RequestMapping("/sendVO")
	public TestVO sendTesTVO() {
		TestVO testVO = new TestVO();
		
		testVO.setName("안재영");
		testVO.setMno(24);
		testVO.setAge(1);
		
		return testVO;
	}
	
	@RequestMapping("/sendVOList")
	public List<TestVO> sendVOList(){
		List<TestVO> testVOList = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			TestVO testVO = new TestVO();
			testVO.setMno(i);
			testVO.setAge(i);
			testVO.setName("사람"+i);
			
			testVOList.add(testVO);
		}
		

		return testVOList;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, TestVO> sendMap(){
		Map<Integer, TestVO> map = new HashMap<>();
		
		for(int i=0; i<10; i++) {
			TestVO testVO = new TestVO();
			testVO.setMno(i);
			testVO.setAge(i);
			testVO.setName("사람"+i);
			
			map.put(i, testVO);
		}
		
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return 
			new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
	}
	@RequestMapping("/sendListNot")
	public ResponseEntity<List<TestVO>> sendListNot(){
		List<TestVO> testVOList = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			TestVO testVO = new TestVO();
			testVO.setMno(i);
			testVO.setAge(i);
			testVO.setName("사람"+i);
			
			testVOList.add(testVO);
		}
		
		return new ResponseEntity<List<TestVO>>(testVOList,HttpStatus.NOT_FOUND);
	}
}
