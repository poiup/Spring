package com.ict.service;

import java.util.List;

import com.ict.vo.ReplyVO;

public interface ReplyService {
	
	public void addReply(ReplyVO vo);
	
	public List<ReplyVO> ListReply(Long bno);
	
	public void modifyReply(ReplyVO vo);
	
	public void removeReply(Long rno);	
	
}
