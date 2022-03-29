package com.ict.controller.di.classfile;

import org.springframework.stereotype.Component;

@Component
public class BalladSinger extends Singer{
	// Singer를 상속해서 sing을 오버라이딩
	@Override
	public void sing() {
		System.out.println("가수가 발라드 노래를 부릅니다");
	}
}
