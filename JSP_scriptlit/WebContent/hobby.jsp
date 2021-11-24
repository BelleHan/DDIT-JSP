<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/getParameter.jsp" method="get">
		취미 : <input type="text" name="hobbies" /><br>
		취미 : <select name="hobbies">
				<option value="야구">야구</option>		
				<option value="축구">축구</option>		
			 </select> <br/>
		취미 : <label for="hobbies1" >수영</label>
			 <input type="checkbox" name="hobbies" value="수영" id="hobbies1"><br/>
			 <label for="hobbies2" >탁구</label>
			 <input type="checkbox" name="hobbies" value="탁구" id="hobbies2"><br/>
		취미 : <textarea rows="5" cols="40" name="hobbies"></textarea>
		<input type="submit" value="전송" />
	</form>
</body>
</html>