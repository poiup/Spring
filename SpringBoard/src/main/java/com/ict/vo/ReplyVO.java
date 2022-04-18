package com.ict.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {

	
	private Long rno;
	private long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
