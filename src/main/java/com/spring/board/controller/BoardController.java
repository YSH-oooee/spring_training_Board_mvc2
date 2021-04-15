package com.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.dto.BoardDTO;
import com.spring.board.service.BoardService;

@Controller	//컨트롤러임을 명시(controller bean에 등록)
public class BoardController {
	
	@Autowired
	private BoardService boardService;	//반드시 인터페이스로 연결
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "board/main";
	}
	
	//value = 접근 url, method = 접근 요청 타입(생략시 GET,POST 모두 처리)
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWrite() {
		return "board/bWrite";	//servlet-context.xml에 명시된대로 포워딩 시켜줄 jsp파일
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWriteAction(BoardDTO bdto) {
		boardService.insertBoard(bdto);
		//List DB를 불러와야하므로 board/bList가 아니라 mapping으로 이동
		return "redirect:boardList";
		//board/bList.jsp파일로 바로 이동 시, mapping을 타지 않으므로 DB를 불러오지않음
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(Model model) {		
		model.addAttribute("boardList", boardService.getBoardList());		
		return "board/bList";		
	}
	
	@RequestMapping(value="/boardInfo")
	public String boardInfo(@RequestParam("num") int num, Model model) {
		model.addAttribute("bdto", boardService.getOneBoard(num));
		return "board/bInfo";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdateForm(@RequestParam("num") int num, Model model) {
		model.addAttribute("bdto", boardService.getOneBoard(num));
		return "board/bUpdate";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardDTO bdto, Model model) {
		if (boardService.updateBoard(bdto)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
		return "board/bUpdatePro";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDeleteForm(@RequestParam("num") int num, Model model) {
		model.addAttribute("bdto", boardService.getOneBoard(num));
		return "board/bDelete";
	}
	
	@RequestMapping(value="/boardDelet", method=RequestMethod.POST)
	public String boardDelete(BoardDTO bdto, Model model) {
		if (boardService.deleteBoard(bdto)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
		return "board/bDeletePro";
	}

}
