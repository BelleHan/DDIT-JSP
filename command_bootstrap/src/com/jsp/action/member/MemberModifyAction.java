package com.jsp.action.member;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.util.GetUploadPath;
import com.jsp.util.MultipartHttpServletRequestParser;

public class MemberModifyAction implements Action {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; //50MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB
	

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/modify_success";
		
		MultipartHttpServletRequestParser multiReq
		= new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		String id = multiReq.getParameter("id");
		String pwd = multiReq.getParameter("pwd");
		String email = multiReq.getParameter("email");
		String authority = multiReq.getParameter("authority");
		String name = multiReq.getParameter("name");
		String phone = multiReq.getParameter("phone");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		member.setAuthority(authority);
		member.setName(name);
		
		// 기존 사진 변경 유무 확인
		String uploadPicture = multiReq.getParameter("uploadPicture");
		if(uploadPicture!=null && !uploadPicture.isEmpty()) { // 사진 변경
			
			//저장경로
			String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
			File file = new File(uploadPath);
			if(!file.mkdir()) {
				System.out.println(uploadPath + "가 이미 존재합니다.");
			}
			
			//기존 사진이미지  삭제
			File deleteFile = new File(uploadPath,multiReq.getParameter("oldPicture"));
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			
			//최근 사진이미지 저장
			List<File> fileList
			= FileUploadResolver.fileUpload(multiReq.getFileItems("picture"), uploadPath);
			File saveFile = fileList.get(0);
			
			member.setPicture(saveFile.getName());
			
		}else {
			member.setPicture(multiReq.getParameter("oldPicture"));
		}
		
		//DB처리
		memberService.modify(member);
		request.setAttribute("member", member);
		
		//로그인 사용자 확인
		request.setAttribute("parentReload", false);
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (member.getId().equals(loginUser.getId())) {
			request.setAttribute("parentReload", true);
			session.setAttribute("loginUser", memberService.getMember(member.getId()));
		}
		
		return url;
	}

}
