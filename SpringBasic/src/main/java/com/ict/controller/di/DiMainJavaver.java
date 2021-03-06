package com.ict.controller.di;

import com.ict.controller.di.classfile.Book;
import com.ict.controller.di.classfile.Library;
import com.ict.controller.di.classfile.Singer;
import com.ict.controller.di.classfile.Stage;

public class DiMainJavaver {

	public static void main(String[] args) {
		// 가수, 무대를 생성한다음
		Singer singer = new Singer();
		Stage stage = new Stage(singer);
		
		// 무대의 공연메서드를 호출해주세요
		stage.perform();
	
		Library library = new Library();
		Book book = new Book();
		library.setBook(book);
		library.browse();
	}
	
}
