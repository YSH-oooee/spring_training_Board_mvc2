package com.spring.board.dao;

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
		sqlSession.insert("com.spring.mapper.BoardMapper.insertBoard", bdto);	//namespace.기능명
		
	}

}
