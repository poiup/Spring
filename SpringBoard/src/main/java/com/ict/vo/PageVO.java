package com.ict.vo;

import lombok.Data;

@Data
public class PageVO {
	private Long pageNum;
	private Long pageList;
	
	public PageVO(){
		this.pageNum = (long) 1;
		this.pageList = (long) 10;
	}
}
