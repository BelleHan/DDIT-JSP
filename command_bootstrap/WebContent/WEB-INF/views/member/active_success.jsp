<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	alert("${member.name}님이 활성되었습니다.");
	location.href='detail.do?id=${member.id}';
</script>