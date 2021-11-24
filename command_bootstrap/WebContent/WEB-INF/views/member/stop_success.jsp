<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	alert("${member.name}님은 정지되었습니다.");
	<c:if test="${empty loginUser}">
		window.opener.parent.location.href="/";
		window.close();
	</c:if>
	<c:if test="${!empty loginUser}">
		location.href="detail.do?id=${member.id}";
	</c:if>
</script>