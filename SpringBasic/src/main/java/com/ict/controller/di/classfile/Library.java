package com.ict.controller.di.classfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Library {
	
	// Library가 Book에 의존하는 상태로 만들어주세요.
	// 단, 생성자는 void생성자(아무것도 입력받지 않고 아무것도 안하는) 로 만들어주시고
	
	// 맴버변수 Book에 대한 setter만 만들어주세요(public void setBook(Book book));
	private Book book;
	public Library() {}
	
	
	//@Autowired는 1, 맴버변수위 , 2. 생성자 위, 3. setter위에 붙일수 있습니다.
	//@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
	
	// 맴버변수 Book을 이용해 "도서관에서 책을 읽습니다." 라는 문장을 실행하는
	// browse 메서드를 생성해주세요.
	
	public void browse() {
		System.out.print("도서관에서 ");
		book.read();
	}
}
