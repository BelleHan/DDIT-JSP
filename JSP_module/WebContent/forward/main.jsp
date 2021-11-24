<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test="${param.page eq 1 }" >
	<jsp:forward page="./1.jsp" >
		<jsp:param name="title" value='<%=URLEncoder.encode("메인페이지","utf-8") %>' />
	</jsp:forward>
</c:if>
<c:if test="${param.page eq 2 }" >
	<jsp:forward page="./2.jsp" />
</c:if>
<c:if test="${param.page eq 3 }" >
	<jsp:forward page="./3.jsp" />
</c:if>