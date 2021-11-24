package com.jsp.action.pds;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.util.MakeFileName;

public class PdsModifyFormAction implements Action {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "pds/modify";
		
			
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		PdsVO pds = pdsService.getPds(pno);
		
		List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
		pds.setAttachList(renamedAttachList);
		
		request.setAttribute("pds", pds);
		
		return url;
			
	}

}
