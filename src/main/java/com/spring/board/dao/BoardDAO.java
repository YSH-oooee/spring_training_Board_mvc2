package com.spring.board.dao;

import java.util.List;

import com.spring.board.dto.BoardDTO;

public interface BoardDAO {
	
	public void insert(BoardDTO bdto);
	public List<BoardDTO> selectAll();
	public BoardDTO selectOne(int num);
	public void increaseReadCount(int num);
	public void update(BoardDTO bdto);
	public void delete(int num);
	public BoardDTO validateUserCheck(BoardDTO bdto);

}
