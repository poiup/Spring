package com.ict.vo;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria{
	private String searchType;
	private String keyword;
}
