package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dto.BoardDTO;

@Repository		//DAO(데이터 접근 객체)임을 명시해야 함 (DAO bean으로 등록)
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;	//root-context.xml에 등록되어있음
	
	@Override
	public void insert(BoardDTO bdto) {
		//BoardMapper에 있는 insertBoard에 bdto정보를 연결
		sqlSession.insert("com.spring.mapper.BoardMapper.insertBoard", bdto);	//namespace.ID
		
	}

	@Override
	public List<BoardDTO> selectAll() {
		return sqlSession.selectList("com.spring.mapper.BoardMapper.getAllBoard");
	}

	@Override
	public BoardDTO selectOne(int num) {
		return sqlSession.selectOne("com.spring.mapper.BoardMapper.getOneBoard", num);
	}

	@Override
	public void increaseReadCount(int num) {
		sqlSession.update("com.spring.mapper.BoardMapper.increaseReadCount", num);
	}

	@Override
	public void update(BoardDTO bdto) {
		sqlSession.update("com.spring.mapper.BoardMapper.updateBoard", bdto);
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("com.spring.mapper.BoardMapper.deleteBoard", num);
	}

	@Override
	public BoardDTO validateUserCheck(BoardDTO bdto) {
		return sqlSession.selectOne("com.spring.mapper.BoardMapper.validateUserCheck", bdto);
	}

}
