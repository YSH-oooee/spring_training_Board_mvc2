
package com.spring.board_advance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.board_advance.dao.BoardAdvanceDAO;
import com.spring.board_advance.dto.BoardAdvanceDTO;

@Service		
public class BoardAdvanceServiceImpl implements BoardAdvanceService {

	@Inject				
	private BoardAdvanceDAO boardDAO;

	@Override
	public List<BoardAdvanceDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception{
		return boardDAO.getSearchBoard(searchInfo);
	}
	 
	
	
	@Override
	public BoardAdvanceDTO getOneBoard(int num) throws Exception{
		boardDAO.increaseReadCount(num);
		return boardDAO.getOneBoard(num);
	}
	
	
	
	@Override
	public void insertBoard(BoardAdvanceDTO bdto) throws Exception {
		boardDAO.insertBoard(bdto);
	}

	
	
	@Override
	public boolean updateBoard(BoardAdvanceDTO bdto) throws Exception {
		boolean isSuccess = false;
		if (boardDAO.validateUserCheck(bdto) != null) {
			isSuccess = true;
			boardDAO.updateBoard(bdto);
		}
		return isSuccess;
	}

	
	
	@Override
	public boolean deleteBoard(BoardAdvanceDTO bdto) throws Exception {
		boolean isSuccess = false;
		if (boardDAO.validateUserCheck(bdto) != null) {
			boardDAO.deleteBoard(bdto.getNum());
			isSuccess = true;
		}
		return isSuccess;
	}

	
	
	@Override
	public void makeDummyData() throws Exception {
		
		Random ran = new Random();
		
		List<BoardAdvanceDTO> dummyDataList = new ArrayList<BoardAdvanceDTO>();
	
		String[] word = {"가","나","다","라","마","바","사","아","자","차","카","타","파","하"};
		
		BoardAdvanceDTO temp = null;
		String writer;
		String password;
		String subject;
		String email;
		String content;
		
		for (int i = 100; i < 300; i++) {
			
			writer    = "";
			password  = "1111";
			subject   = "";
			email     = "";
			content   = "";
			for (int j = 0; j < 7; j++) {
				writer  += word[ran.nextInt(word.length)];
				subject += word[ran.nextInt(word.length)];
				content += word[ran.nextInt(word.length)];
				if (j < 4) {
					email += word[ran.nextInt(word.length)];
				}
			}
			email += "@gmail.com";
			
			temp = new BoardAdvanceDTO();
			temp.setNum(i);		
			temp.setWriter(writer);
			temp.setEmail(email);
			temp.setSubject(subject);
			temp.setPassword(password);
			temp.setRef(i);
			temp.setReLevel(1);
			temp.setReStep(1);
			temp.setReadCount(0);
			temp.setContent(content);
			
			dummyDataList.add(temp);
			
		}
		
		boardDAO.makeDummyData(dummyDataList);
		
	}

	
	
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		return boardDAO.getAllBoardCount(searchCountInfo);
	}

	
	
	@Override
	public void insertReplyBoard(BoardAdvanceDTO bdto) throws Exception {
		boardDAO.updateBoardReplyStep(bdto);
		boardDAO.insertReplyBoard(bdto);
	}
	
}
