package com.ict.controller.di.classfile;

import org.springframework.stereotype.Component;

@Component
public class Book {
	public void read() {
		System.out.println("책을 읽습니다.");
	}
}
