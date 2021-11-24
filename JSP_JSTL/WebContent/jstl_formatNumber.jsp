<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="price" value="10000" />

<h1>가격 : ${price }</h1>
<h1>가격 : <fmt:formatNumber value="${price }" pattern="#,###" /></h1>

<c:set var="phone" value="01012341234"/>
<h1>전화번호 : ${phone }</h1>
<h1>전화번호 : <fmt:formatNumber var="won" value="${price }" pattern="###-####-####"/><br/>
            ${phone.substring(0,3) }-${phone.substring(3,7)}-${phone.substring(7) }

</h1>

<h1>won : ${won }</h1>