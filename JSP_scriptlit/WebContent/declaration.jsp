<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%!private int int1;
   private int int2;

   public int sum(String intStr1, String intStr2) {
      this.int1 = Integer.parseInt(intStr1);
      this.int2 = Integer.parseInt(intStr2);

      return int1 + int2;

   }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
   <ul>
      <li>정수1: <%=request.getParameter("int1")%></li>
      <li>정수2: <%=request.getParameter("int2")%></li>
      
      <li>두 정수의 합: <%=sum(request.getParameter("int1"), request.getParameter("int2"))%></li>
   </ul>

</body>
</html>