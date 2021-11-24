<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% pageContext.setAttribute("message", "안녕하세요"); %>
<%! String msg = "1234"; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>메세지 : ${message }</h1>
	
	<h1> jsp:include : <%-- 	<jsp:include page="./sub.jsp" /> --%></h1>
	<h1> @ include : <%@ include file="./sub.jsp" %></h1>
	<h1> msg : <%=msg %></h1>
	<h1>배불러</h1>

</body>
</html>