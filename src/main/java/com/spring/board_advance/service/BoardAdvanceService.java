package com.spring.board_advance.service;

import java.util.List;
import java.util.Map;

import com.spring.board_advance.dto.BoardAdvanceDTO;

public interface BoardAdvanceService {
	
	public List<BoardAdvanceDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public BoardAdvanceDTO getOneBoard(int num) throws Exception;
	public void insertBoard(BoardAdvanceDTO bdto) throws Exception;
	public void insertReplyBoard(BoardAdvanceDTO bdto) throws Exception;
	public boolean updateBoard(BoardAdvanceDTO bdto) throws Exception;
	public boolean deleteBoard(BoardAdvanceDTO bdto) throws Exception;
	public void makeDummyData() throws Exception;
	
}
