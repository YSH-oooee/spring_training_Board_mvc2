package com.spring.board_advance.dao;

import java.util.List;
import java.util.Map;

import com.spring.board_advance.dto.BoardAdvanceDTO;

public interface BoardAdvanceDAO {

	public List<BoardAdvanceDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public BoardAdvanceDTO getOneBoard(int num) throws Exception;
	public void increaseReadCount(int readCount) throws Exception;
	public void insertBoard(BoardAdvanceDTO bdto) throws Exception;
	public void insertReplyBoard(BoardAdvanceDTO bdto) throws Exception;
	public void updateBoard(BoardAdvanceDTO bdto) throws Exception;
	public void deleteBoard(int num) throws Exception;
	public void updateBoardReplyStep(BoardAdvanceDTO bdto) throws Exception;
	public BoardAdvanceDTO validateUserCheck(BoardAdvanceDTO bdto) throws Exception;
	public void makeDummyData(List<BoardAdvanceDTO> dataLists) throws Exception;

}
