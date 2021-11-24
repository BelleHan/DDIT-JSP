<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="sum"  value="0" />
<c:forEach begin="1" end="10" var="i" step="1">
	<c:set var="sum" value="${sum+i }" />
</c:forEach>

jstl : ${sum }

<br/>

<%
	int sum = 0;
	for(int i=1; i<=10; i++) sum+=i;
	out.println(sum);
%>

<br />
<c:set var="num" value="11,22,33,44,55"/>
<c:forEach items="${num }" var="i" varStatus="status">
	${i} : ${status.count } : ${status.index }<br/>
</c:forEach>

<%
	int[] num = {1,2,3,4,5};
	for(int i : num){
		out.println(i);
	}
%>