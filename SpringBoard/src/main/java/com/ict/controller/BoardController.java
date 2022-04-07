package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ict.mapper.BoardMapper;
import com.ict.vo.BoardVO;

import lombok.extern.log4j.Log4j;


//컨트롤러가 컨트롤러 기능을 할수 있도록 처리해주세요
@Controller
@Log4j
public class BoardController {
	@Autowired
	private BoardMapper boardMapper;
	// 전체회원을 보려면, 회원 목록을 들고오는 메서드를 실행해야하고
	// 그러면, 그 메서드를 보유하고있는 클래스를 선언하고 주입해줘야 합니다.
	@GetMapping(value="/boardList")
	public String boardList(Model model) {
		List<BoardVO> boardList = boardMapper.getList();
		
		model.addAttribute("boardList",boardList);
		return "boardList";
	}
	
	// 글 하나만 조회할수 있는 디테일 페이지만 boardDetail.jsp로 연결되는
	// /boardDetail 주소를 get방식으로 선언해주세요
	// 숙제 : @PathVariable적용 방식으로 교체
	/*
	@GetMapping(value="/boardDetail")
	public String boardDetail(long bno, Model model) {
		BoardVO board = boardMapper.getboard(bno);
		
		model.addAttribute("board", board);
		return "boardDetail";
	}
	*/
	@GetMapping(value="/boardDetail/{bno}")
	public String boardDetail(@PathVariable long bno, Model model) {
		BoardVO board = boardMapper.getboard(bno);
		
		model.addAttribute("board", board);
		return "boardDetail";
	}

}
