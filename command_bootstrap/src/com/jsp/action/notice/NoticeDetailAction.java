package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeDetailAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/detail";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		String from = request.getParameter("from");
		
		NoticeVO notice = null;
		if(from!=null && from.equals("modify")) {
			notice = noticeService.getNoticeForModify(nno);
		}else {
			notice = noticeService.getNotice(nno);
		}
		
		request.setAttribute("notice", notice);
		
		return url;
	}

}
