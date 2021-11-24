package com.jsp.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.JSONResolver;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class GetMcodeByMnameAction implements Action {
	
	private MenuService menuService;
    public void setMemberService(MenuService menuService) {
       this.menuService = menuService;
    }

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String mname = request.getParameter("mName");
		
		MenuVO menu = menuService.getMenuByMname(mname);
		
		JSONResolver.view(response, menu);
		
		return url;
		
	}

}
