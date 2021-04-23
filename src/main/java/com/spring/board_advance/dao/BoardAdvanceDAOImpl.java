package com.spring.board_advance.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board_advance.dto.BoardAdvanceDTO;

@Repository				
public class BoardAdvanceDAOImpl implements BoardAdvanceDAO {

	
	@Inject							
	private SqlSession session;		
	
	@Override
	public List<BoardAdvanceDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception{
		return session.selectList("com.spring.mapper.BoardAdvanceMapper.getSearchBoard",searchInfo);
	}
	
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		return session.selectOne("com.spring.mapper.BoardAdvanceMapper.getAllBoardCount" , searchCountInfo);
	}
	
	@Override
	public BoardAdvanceDTO getOneBoard(int num) throws Exception{
		return session.selectOne("com.spring.mapper.BoardAdvanceMapper.getOneBoard",num);
	}
	
	@Override
	public void increaseReadCount(int num) throws Exception {
		session.update("com.spring.mapper.BoardAdvanceMapper.increaseReadCount",num);
	}
	
	@Override
	public void insertBoard(BoardAdvanceDTO bdto) throws Exception{
		session.insert("com.spring.mapper.BoardAdvanceMapper.insertBoard",bdto);
	}
	
	@Override
	public void insertReplyBoard(BoardAdvanceDTO bdto) throws Exception {
		session.insert("com.spring.mapper.BoardAdvanceMapper.insertReplyBoard",bdto);
	}
	
	@Override
	public void updateBoard(BoardAdvanceDTO bdto) throws Exception{
		session.update("com.spring.mapper.BoardAdvanceMapper.updateBoard",bdto);
	}

	@Override
	public void deleteBoard(int num) throws Exception{
		session.delete("com.spring.mapper.BoardAdvanceMapper.deleteBoard",num);
	}

	@Override
	public void updateBoardReplyStep(BoardAdvanceDTO bdto) throws Exception {
		session.update("com.spring.mapper.BoardAdvanceMapper.updateBoardReplyStep" , bdto);
	}
	
	@Override
	public BoardAdvanceDTO validateUserCheck(BoardAdvanceDTO bdto) throws Exception {
		return session.selectOne("com.spring.mapper.BoardAdvanceMapper.validateUserCheck",bdto);
	}

	@Override
	public void makeDummyData(List<BoardAdvanceDTO> dataLists) throws Exception {
		session.insert("com.spring.mapper.BoardAdvanceMapper.makeDummyData" , dataLists);
	}



}
