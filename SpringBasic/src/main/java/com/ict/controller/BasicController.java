package com.ict.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BasicController {

	// RequestMapping의 value는 localhost:8181/어떤주소 로 접속시 해당 로직이 샐행될지 결정합니다.
	//아무것도 안적혀있으면 기본적으로 get방식을 허용합니다.
	@RequestMapping(value="/goA")
	// 아래에 해당 주소로 접속시 실행하고 싶은 메서드를 작성합니다
	public String goA() {
		System.out.println("goA로 접속이 감지되었습니다.");
		// return "goA" 라고 적으면 view폴더 내부의 goA.jsp파일을 보여줍니다.
		return "goA";
	}
	@RequestMapping(value="/goB")
	// 아래에 해당 주소로 접속시 실행하고 싶은 메서드를 작성합니다
	public String goB() {
		System.out.println("goB로 접속이 감지되었습니다.");
		// goB로 접속하면 b.jsp파일을 보여줍니다
		return "b";
	}
	@RequestMapping(value="/an")
	public String an() {
		return "an";
	}	
	@RequestMapping(value="/getData", method=RequestMethod.POST)
						// /getData?data1=데이터&data2=데이터
	public String getData(String data1, int data2, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		model.addAttribute("data1",data1);
		model.addAttribute("data2",data2);
		return "getResult";
	}
	
	// 외부에서 전송하는 데이터를 /getMoney주소로 받아오겠습니다.
	// 이 주소는 int won이라는 형식으로 금액을 받아서
	// 환울에 따른 호나전금액을 콘솔에 찍어줍니다.
	// 결과페이지는 exchange로 하겠습니다.
	// 메서드명은 임의로 만들어주세요.
	@RequestMapping(value="/getMoney", method=RequestMethod.POST)
	public String getMoney(int won, Model model) {
		double cfp = 0.089;
		System.out.println(won + "원 을 프랑으로 환전을하면 " + (won * cfp) + "입니다.");
		model.addAttribute("won", won);
		model.addAttribute("cfp", cfp);

		return "exchange";
	}
	
	// form 페이지와 결과 페이지를 분리해야합니다.
	// 다만 목적지 주소가 .jsp기준이 아닌, @RequestMapping상의 주소 기준으로 갑니다.
	// 주소 moneyform으로 연결되도록 아래에 어노테이션 + 메서드를 구성해주세요.
	// moneyform.jsp로 연결됩니다.
	// moneyForm.jsp에는 목적지를 #으로 하고
	// name=won인 폼을 추가로 만들어주세요.
	
	@RequestMapping(value="/moneyForm")
	public String moneyForm() {
		
		
		return "moneyForm";
	}
	
	// 상단 /getData 주소를 타겟으로 하는 /dataForm을 만들어주세요.
	// data1, data2를 자료형에 맞게 폼으로 입력받아 전송버튼을 누르면
	// 해당 데이터가 결과 페이지에 나올수 있도록 .jsp파일부터 tlwkrgotje
	// form태그나 세부 로직까지 완성시켜주세요.
	// 1. 주소및 연결 메서드 완성후 보내주세요.
	// 2. form태그 완성후 보내주세요
	@RequestMapping(value="/dataForm")
	public String dataForm() {
		return "dataForm";
	}

	// 스프링 5버전 부터 허용
	// @요청메서드Mapping은 해당 메서드만 허용하는 어노테이션입니ㅏㄷ
	@GetMapping(value="/onlyGet")
	public String onlyGet() {
		return "onlyGet";
	}
	
	@GetMapping(value="/score")
	public String getscore() {
		return "getScore";
	}
	@PostMapping(value="/score")
	public String postscore(int meth, int eng, int lang,int soc, int com, Model model) {
		double total = (meth+eng+soc+com + lang)/5.0;
		model.addAttribute("total",total);
		model.addAttribute("meth",meth);
		model.addAttribute("eng",eng);
		model.addAttribute("lang",lang);
		model.addAttribute("com",com);
		model.addAttribute("soc",soc);
		return "postScore";
	}
}
