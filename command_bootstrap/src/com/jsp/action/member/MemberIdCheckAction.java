package com.jsp.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberIdCheckAction implements Action {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		String resultStr = "";
		
		String id=request.getParameter("id");
		
		MemberVO member = memberService.getMember(id);
		if(member!=null) {
			resultStr="duplicated";
		}
		
		PrintWriter out = response.getWriter();
		out.print(resultStr);
		out.close();
		
		return url;
		
	}

}
