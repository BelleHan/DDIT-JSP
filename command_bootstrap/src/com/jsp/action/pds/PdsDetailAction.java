package com.jsp.action.pds;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.util.MakeFileName;

public class PdsDetailAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="pds/detail";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String from = request.getParameter("from");
		
		try {
			PdsVO pds = pdsService.getPds(pno);
			if(from!=null && from.equals("modify")) {
				pds = pdsService.getPds(pno);
			}else {
				pds = pdsService.read(pno);
			}
			
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			
			request.setAttribute("pds", pds);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		return url;
	}

}
