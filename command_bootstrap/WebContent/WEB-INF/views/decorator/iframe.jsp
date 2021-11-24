<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<jsp:include page="/WEB-INF/views/include/style.jsp" />
<sitemesh:write property="head" />
</head>
<body>

<sitemesh:write property="body" />

<jsp:include page="/WEB-INF/views/include/js.jsp" />

</body>
</html>