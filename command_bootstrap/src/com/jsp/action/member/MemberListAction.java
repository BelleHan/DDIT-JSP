package com.jsp.action.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;

public class MemberListAction implements Action {
   
   private MemberService memberService;
   public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
   }

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String url = "member/list";
      
      String pageParam = request.getParameter("page");
      String perPageNumParam = request.getParameter("perPageNum");
      String searchType = request.getParameter("searchType");
      String keyword = request.getParameter("keyword");
      
      SearchCriteria cri = new SearchCriteria();
      cri.setPage(pageParam);
      cri.setPerPageNum(perPageNumParam);
      cri.setSearchType(searchType);
      cri.setKeyword(keyword);
      
      Map<String, Object> dataMap = memberService.getMemberList(cri);
      
      request.setAttribute("memberList", dataMap.get("memberList"));
      request.setAttribute("pageMaker", dataMap.get("pageMaker"));
      
      return url;
   }

}