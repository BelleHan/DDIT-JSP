package com.jsp.action.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.JSONResolver;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;


public class SubMenuAction implements Action {
   
   private MenuService menuService;
   public void setMenuService(MenuService menuService) {
      this.menuService = menuService;
   }
   
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // 원래는 viewName을 주지만, 화면은 없다는 의미로 null을 준다.
      String url = null; 
      
      String mCode = request.getParameter("mCode");
      List<MenuVO> subMenu = null;
      
      
      try {
         subMenu = menuService.getSubMenuList(mCode);
         
         JSONResolver.view(response, subMenu);
         
      } catch (Exception e) {
         response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
         e.printStackTrace();
      }
   
      return url;
   }

}