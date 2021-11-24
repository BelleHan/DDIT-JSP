<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=URLDecoder.decode(request.getParameter("title"),"utf-8") %></title>
</head>
<body>
	<h1>1.jsp</h1>
</body>
</html>