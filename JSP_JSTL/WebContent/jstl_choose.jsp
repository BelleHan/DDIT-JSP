<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${param.id eq 'mimi' }">
		<script>
			alert("미미야 안녕");
		</script>
	</c:when>	
	<c:when test="${param.id eq 'mama' }">
		<script>
			alert("마마야 안녕");
		</script>
	</c:when>	
	<c:otherwise>
		<script>
			alert("누구세요?");
		</script>
	</c:otherwise>
</c:choose>

<%-- <%
	String param = request.getParameter("id");
	if(param.equals("mimi")){
%>
	<script>
		alert("미미야 안녕?");
	</script>
<%
	}else if(param.equals("mama")){
%>
		
	<script>
		alert("미미야 안녕?");
	</script>
<%
	}else{
%>
	<script>
		alert("누구세요?");
	</script>
<%
	}
%> --%>