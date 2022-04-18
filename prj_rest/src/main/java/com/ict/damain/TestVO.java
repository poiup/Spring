package com.ict.damain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data 순환참조 문제가 있음
// @AllArgsConstructor
// @NoArgsConstructor
@ToString
@Getter
@Setter
public class TestVO {
	private Integer mno;
	private String Name;
	private Integer age;
}
