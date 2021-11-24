package com.jsp.action.reply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

public class ReplyRemoveAction implements Action {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int rno = Integer.parseInt((String)request.getParameter("rno"));
		int page = Integer.parseInt((String)request.getParameter("page"));
		int bno = Integer.parseInt((String)request.getParameter("bno"));
		
		try {
			
			replyService.removeReply(rno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(replyService.getReplyListCount(bno));
			
			int realEndPage = pageMaker.getRealEndPage();
			
			if(page>realEndPage) {page=realEndPage;}
			
			PrintWriter out = response.getWriter();
			out.print(page);
			out.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return url;
	}

}
