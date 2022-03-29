package com.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	@RequestMapping(value="/getData")
						// /getData?data1=데이터&data2=데이터
	public String getData(String data1, int data2) {
		System.out.println("data1에 든 값 : " +  data1);
		System.out.println("data2에 든 값 : "+ data2);
		System.out.println("data2가 정수임을 증명 " + (data2+100));
		return "getResult";
	}
	
	// 외부에서 전송하는 데이터를 /getMoney주소로 받아오겠습니다.
	// 이 주소는 int won이라는 형식으로 금액을 받아서
	// 환울에 따른 호나전금액을 콘솔에 찍어줍니다.
	// 결과페이지는 exchange로 하겠습니다.
	// 메서드명은 임의로 만들어주세요.
	@RequestMapping(value="/getMoney")
	public String getMoney(int won) {
		double cfp = 0.089;
		System.out.println(won + "원 을 프랑으로 환전을하면 " + (won * cfp) + "입니다.");
		return "exchange.jsp";
	}
}
