package com.ict.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.service.BoardService;
import com.ict.vo.BoardVO;
import com.ict.vo.SearchCriteria;
import com.ict.vo.pageMaker;

import lombok.extern.log4j.Log4j;


//컨트롤러가 컨트롤러 기능을 할수 있도록 처리해주세요
@Controller
@Log4j
public class BoardController {
	// 컨트롤러는 Service만 호출하도록 구조를 바꿉니다.
	// Service를 BoardController 내부에서 쓸수 있도록 선언/주입해주세요.
	@Autowired
	private BoardService Service;
	// 전체회원을 보려면, 회원 목록을 들고오는 메서드를 실행해야하고
	// 그러면, 그 메서드를 보유하고있는 클래스를 선언하고 주입해줘야 합니다.
	@GetMapping(value="/boardList")
	public String boardList(SearchCriteria cri, Model model, HttpServletRequest request, HttpSession session) {
	// public String boardList(@RequestParam(name="pageNum" defaultValue = "1")Long pageNum, Long pageList, Model model)	
		
		List<BoardVO> boardList = Service.getList(cri);
		model.addAttribute("boardList",boardList);
		
		pageMaker pageMaker = new pageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalBoard(Service.countPageNum()); // totalBoard안에잇는 calc()까지 호출이됨
		model.addAttribute("pageMaker", pageMaker);
		
		if(session.getAttribute("sessionCri") == null) {
			session.setAttribute("sessionCri", pageMaker.getCri());
		} else if(session.getAttribute("sessionCri") != null && cri.getKeyword() != null && cri.getSearchType() != null) {
			session.setAttribute("sessionCri", pageMaker.getCri());
		}
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
		BoardVO board = Service.getboard(bno);	
		model.addAttribute("board", board);
		return "boardDetail";
	}
	
	// insert페이지를 위한 form으로 연결되는 컨트롤러 생성
	// get방식으로 /boardInsert주소로 접속시 form페이지로 연결됩니다
	// 폼 페이지의 이름은 boardForm.jsp
	@GetMapping(value="/boardInsert")
	public String boardForm() {
		
		return "boardForm";
	}
	
	@PostMapping(value="/boardInsert")
	public String boardInsert(BoardVO board) {
		
		log.info(board);
		Service.insertBoard(board);
		
		return "redirect:/boardList";
	}
	
	// 글삭제 로직은 Post방식으로 진행합니다.
	// /boardDelete 주소로 처리하고
	// bno를 받아서 해당 글을 삭제합니다.
	// 글 삭제 버튼은 detail페이지 하단에 form으로 만들어서 bno를 hidden으로 전달하는
	// submit버튼을 생성해서 처리해주세요
	@PostMapping(value="/boardDelete")
	public String boardDelete(long bno) {
		Service.delBoard(bno);
		
		return "redirect:/boardList";
	}
	
	// 업데이트 폼
		@PostMapping(value="/boardUpdateForm")
		public String boardUpdateForm(@RequestParam long bno, Model model) {
			log.info(bno);
			BoardVO board = Service.getboard(bno);
			model.addAttribute("board", board);
			log.info(board);
			return "/boardUpdateForm";
		}
		
		// 업데이트 진행
		@PostMapping(value="/boardUpdate")
		public String boardForm(BoardVO board) {
			log.info(board);
			Service.upDateBoard(board);	
			return "redirect:/boardDetail/"+board.getBno();
		}

}
