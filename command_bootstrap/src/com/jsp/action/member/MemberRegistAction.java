package com.jsp.action.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberRegistAction implements Action {
	
	private MemberService memberService;
    public void setMemberService(MemberService memberService) {
       this.memberService = memberService;
    }

    
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url="member/regist_success";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String authority = request.getParameter("authority");
		String name = request.getParameter("name");
		
		String phone = "";
		for (String data : request.getParameterValues("phone")) {
			phone += data;
		}
		
		// MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPicture(picture);
		member.setAuthority(authority);
		member.setName(name);
		
		try {
			memberService.regist(member);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		return url;
	}

}
