package com.jsp.action.board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardModifyAction implements Action {
	
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService=boardService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면결정
		String url = "redirect:board/detail.do?from=modify&bno="+request.getParameter("bno");		
		
		XSSResolver.parseXSS(request);
		
		// 파라메터 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		// String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String title =(String)request.getAttribute("XSStitle");

	
		
		BoardVO board = new BoardVO(); 
		board.setBno(bno);
		board.setContent(content);
		board.setTitle(title);
		board.setWriter(writer);
		

		// 서비스를 의뢰 (결과 할당)"
		try {
			boardService.modify(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 화면리턴		
		return url;
	}
	
	

}
