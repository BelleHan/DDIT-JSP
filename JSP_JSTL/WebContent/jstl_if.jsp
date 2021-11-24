```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${param.id eq 'mimi' }" >
	<script>
		alert("미미야 안녕?");
	</script>
</c:if>

<%
	String param = request.getParameter("id");
	if(param.equals("mimi")){
%>
	<script>
		alert("미미야 안녕?");
	</script>
<%
	}
%>