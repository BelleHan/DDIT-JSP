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
	<form id="form" action="https://www.naver.com">
		<input type="text" />
		<input type="submit" id="submit_btn" onclick="regist_go(); return false;" value="전송"/>
	</form>
	
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

// $('input#submit_btn').click(function(event){
// 	regist_go();
	
// });

function regist_go() {
	alert("submit btn");
	return false;
}

</script>

</body>
</html>