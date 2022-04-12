package com.ict.vo;

import lombok.Data;

@Data
public class pageMaker {
	private Criteria cri;
	private int totalBoard;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	// 만약 페이지 하단 버튼개수를 유동적으로 가져가고 싶은경우
	// displayPageNum을 선언합니다.
	private int displayPageNum;
	
	
	public void calcData() {
		this.displayPageNum = 10;
		
		this.endPage = (int)(Math.ceil
				(cri.getPageNum() / (double) displayPageNum) * displayPageNum
				);
		
		this.startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalBoard / (double)cri.getNumber()));

		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// prev는 startPage가 1인 경우에 비활성화
		prev = startPage == 1 ? false : true;
		
		// next는 endPage*페이지번호가 totalBoard보다 작으면 활성화
		next = endPage * cri.getNumber() >= totalBoard ? false : true;
	}
	
	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
		calcData();
	}
}
