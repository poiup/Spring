package com.ict.vo;

import java.sql.Date;

// lombok을 이용해 get-setter, 생성자, toString을 만들어주세요.
import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}

