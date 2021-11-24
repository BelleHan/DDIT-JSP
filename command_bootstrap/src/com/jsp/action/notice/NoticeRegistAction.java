package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="notice/regist_success";
		
		XSSResolver.parseXSS(request);
		
		//String title = request.getParameter("title");
		String title = (String) request.getAttribute("XSStitle");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriter(writer);
		
		noticeService.regist(notice);
		
		return url;
	}

}
