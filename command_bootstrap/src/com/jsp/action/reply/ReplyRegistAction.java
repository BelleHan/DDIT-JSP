package com.jsp.action.reply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.request.PageMaker;
import com.jsp.request.ReplyRegistCommand;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

public class ReplyRegistAction implements Action {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		ReplyRegistCommand replyReq
		= mapper.readValue(request.getReader(), ReplyRegistCommand.class);
		
		try {
			replyService.registReply(replyReq.toReplyVO());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		int realEndPage = 1;
		
		String result="";
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(replyService.getReplyListCount(replyReq.toReplyVO().getBno()));
			
			realEndPage = pageMaker.getRealEndPage();
			
			result = "SUCCESS,";
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Fail,";
		}
		
		PrintWriter out = response.getWriter();
		out.print(result+realEndPage);
		
		return url;
	}

}
