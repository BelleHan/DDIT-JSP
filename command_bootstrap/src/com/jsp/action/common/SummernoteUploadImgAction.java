package com.jsp.action.common;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.util.GetUploadPath;
import com.jsp.util.MultipartHttpServletRequestParser;

public class SummernoteUploadImgAction implements Action {
	
	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 5; // 5MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 10; // 10MB

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		// request parsing
		MultipartHttpServletRequestParser multi
		= new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

		// file save
		String uploadPath = GetUploadPath.getUploadPath("summernote.img"); // 저장경로
		
		List<File> fileList
		= FileUploadResolver.fileUpload(multi.getFileItems("file"), uploadPath);
		
		// response out
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (fileList.size() > 0) {
			for (File file : fileList) {
				out.print(request.getContextPath() + 
						"/getImg.do?fileName=" + file.getName());
			}
		}
			

		return url;
	}

}
