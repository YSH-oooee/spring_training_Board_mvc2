package com.spring.board.service;

import java.util.List;

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

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.selectAll();
	}

	@Override
	public BoardDTO getOneBoard(int num) {
		boardDAO.increaseReadCount(num);	//조회수 증가
		return boardDAO.selectOne(num);
	}

	@Override
	public boolean updateBoard(BoardDTO bdto) {
		boolean isSucceed = false;
		
		if (boardDAO.validateUserCheck(bdto) != null) {
			boardDAO.update(bdto);
			isSucceed = true;
		}
		
		return isSucceed;
	}

	@Override
	public boolean deleteBoard(BoardDTO bdto) {
		boolean isSucceed = false;
		
		if (boardDAO.validateUserCheck(bdto) != null) {
			boardDAO.delete(bdto.getNum());
			isSucceed = true;
		}
		
		return isSucceed;
	}

}
