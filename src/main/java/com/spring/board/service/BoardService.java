package com.spring.board.service;

import java.util.List;

import com.spring.board.dto.BoardDTO;

public interface BoardService {
	
	public void insertBoard(BoardDTO bdto);
	public List<BoardDTO> getBoardList();
	public BoardDTO getOneBoard(int num);
	public boolean updateBoard(BoardDTO bdto);
	public boolean deleteBoard(BoardDTO bdto);

}
