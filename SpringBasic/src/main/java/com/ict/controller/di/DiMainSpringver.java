package com.ict.controller.di;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ict.controller.di.classfile.BalladSinger;
import com.ict.controller.di.classfile.Book;
import com.ict.controller.di.classfile.Broadcast;
import com.ict.controller.di.classfile.Library;
import com.ict.controller.di.classfile.PopSinger;
import com.ict.controller.di.classfile.Singer;
import com.ict.controller.di.classfile.Stage;

public class DiMainSpringver {

	public static void main(String[] args) {
		String[] address = {"file:src/main/webapp/WEB-INF/spring/root-context2.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"};
		// root-context라는 공장에 저장된 객체를 뽑아서 써야합니다
		// 가져오기 위한 호출 코드를 작성해보겠습니다.
	//	GenericXmlApplicationContext context = 
	//			new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(address);
		// 공장 내부 객체 가져오기
		// context.getBean("내부명칭",클래스파밍ㄹ명.class);
		//Singer singer = context.getBean("singer", Singer.class);
		//Stage stage = context.getBean("stage", Stage.class);
		
		
		// 가져온 객체 사용
		//singer.sing();
		//stage.perform();
		
		// 1. Broadcast 클래스를 만들어주세요
		// 2. Broadcast의 송출기능을 담당하는 onAir메서드는
		// "방송 송출중인 무대에서 가수가 노래를 합니다." 라는 문장이 나오도록 세팅해주세요
		// 3. DiMainSpringver에서 Stage와 Singer를 건너뛰고 바로 Broadcast를 만들어서
		// 실행할수 있도록 세팅을 마친다음 실제로 실행까지 해주세요.
		//Broadcast broadcast = context.getBean("broadcast", Broadcast.class);
		//broadcast.onAir();
		
		Stage stage1 = context.getBean("stage1", Stage.class);
		Stage stage2 = context.getBean("stage2", Stage.class);

		stage1.perform();
		stage2.perform();
		//Singer balladSinger = context.getBean("balladSinger", BalladSinger.class);
		//balladSinger.sing();
		
		//Singer popSinger = context.getBean("popSinger", PopSinger.class);
		//popSinger.sing();
		Library library = context.getBean("library1", Library.class);
		library.browse();
	}

}
