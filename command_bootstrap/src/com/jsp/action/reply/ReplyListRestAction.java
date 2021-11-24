package com.jsp.action.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.JSONResolver;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

public class ReplyListRestAction implements Action {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
