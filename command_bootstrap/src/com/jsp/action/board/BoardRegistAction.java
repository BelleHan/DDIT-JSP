package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardRegistAction implements Action {
	
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "board/regist_success";
	
		//String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		XSSResolver.parseXSS(request);
		
		BoardVO board = new BoardVO(); 
		board.setContent(content);
		board.setTitle((String)request.getAttribute("XSStitle"));
		board.setWriter(writer);
		
		boardService.regist(board);
		
		
		return url;
	}

}
