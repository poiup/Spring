package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ict.mapper.BoardMapper;
import com.ict.mapper.ReplyMapper;
import com.ict.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper bMapper;
	
	@Override
	public void addReply(ReplyVO vo) {
		mapper.create(vo);
		
	}

	@Override
	public List<ReplyVO> ListReply(Long bno) {
		return mapper.getList(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		mapper.update(vo);
		
	}
	
	@Transactional
	@Override
	public void removeReply(Long rno) {
		Long bno = mapper.getBno(rno);
	//	bMapper.updateReply(bno , -1);
		mapper.delete(rno);
	}
	
	

}
