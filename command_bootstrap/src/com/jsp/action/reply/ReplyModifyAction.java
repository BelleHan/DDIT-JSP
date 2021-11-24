package com.jsp.action.reply;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.dto.ReplyVO;
import com.jsp.request.ReplyModifyCommand;
import com.jsp.service.ReplyService;

public class ReplyModifyAction implements Action {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		ReplyModifyCommand replyReq
		= mapper.readValue(request.getReader(), ReplyModifyCommand.class);
		
		try {
			ReplyVO reply = replyReq.toReplyVO();
			replyService.modifyReply(reply);
			
			response.sendError(HttpServletResponse.SC_OK);
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return url;
	}

}
