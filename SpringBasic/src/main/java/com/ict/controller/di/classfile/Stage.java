package com.ict.controller.di.classfile;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Stage {
	
	// 5버전 보다 낮은버전에서는 아무작업도 하지 않는 디폴트 생성자와 @Autowired를 
	// 입력해줘야 해당 자료형과 일치하는 부품이 공장내에 존재하면 자동으로 결합해줍니다.
	// 5버전에서는 1개 이하의 맴버변수는 자동으로 처리해줍니다.
	// 변수위,생성자위 중 하나를 고르시면 됩니다.
	// @Autowired는 @Inject로 대체가 가능합니다
	//@Autowired
	// 2개 이상의 맴버변수가 생기게되면 Spring에서 뭘 사용해야할지 판단을 할수없어 오류가난다.
	// 이를 해결하기 위해 @Qualifier("내부명칭")을 적어준뒤 디폴트생성자를 생성하여 해결할수 있다.
	//@Qualifier("popSinger") // @Qualifier또한 @Resource로 대체가 가능합니다.
	private Singer singer;
	public Stage() {}
	 
	//public Stage() {}
	public Stage(Singer singer) {
		this.singer = singer;
	}
	
	public void perform() {
		System.out.print("무대에서 ");
		this.singer.sing();
	}
}
