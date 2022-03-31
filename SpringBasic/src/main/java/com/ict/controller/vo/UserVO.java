package com.ict.controller.vo;

import lombok.Data;

// lombok의 @Data는 해당 VO의 setter,getter, 생성자, toString을 자동생성해줍니다.
// 단, lombok을 사용하기위해서는 1. lombok설치 -> pom.xml에 lombok관련 세팅을 해야합니다.
// mvn리포지터리에서 lombok가져와서 pom에 넣어주기
// 가상의 "회원관리용 VO"
@Data
public class UserVO {
	
	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
}
