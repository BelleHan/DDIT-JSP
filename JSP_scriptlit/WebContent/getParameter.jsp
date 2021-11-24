<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%-- <body>	<%=((MemberVO)request.getAttribute("member")).getId() %> --%>
		${member.id }

<%-- 	<% request.setCharacterEncoding("utf-8"); %> --%>

	<h3> 아이디: <%-- <% out.println(request.getParameter("id")); %> --%>
					<%=request.getParameter("id") %>
	</h3>
	<h3> 패스워드: <%-- <% out.println(request.getParameter("pwd")); %>  --%>
					<%=request.getParameter("pwd") %>
	</h3>
	<h3> 취미 : 한개가져오기<%=request.getParameter("hobbies") %></h3>
	<h3> 취미 : 모두 가져오기<%=Arrays.asList(request.getParameterValues("hobbies")) %></h3>

	<%
		Map<String, String[]> paramMap = request.getParameterMap();
	%>
	<h3>맵에서 꺼내기 hobbies : <%=paramMap.get("hobbies")[0] %></h3>
	<h3>맵에 넣기 : <% 
					String[] values = {"mimi"};
					//paramMap.put("id", values); %></h3>
</body>
</html>