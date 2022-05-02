package com.ict.mapper;

import java.util.List;

import com.ict.vo.ReplyVO;

public interface ReplyMapper {
	
	
	public List<ReplyVO> getList(Long bno);
	
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	// 댓글삭제시에는 댓글번호 하나만 받아서 해당 댓글만 지운다.
	public void delete(Long rno);
	public Long getBno(Long rno);
		
}
