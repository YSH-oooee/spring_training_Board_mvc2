package com.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDAO;
import com.spring.board.dto.BoardDTO;

@Service	//서비스(비즈니스 로직)임을 명시(service bean으로 등록)
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO bdto) {
		
		boardDAO.insert(bdto);

	}

}
