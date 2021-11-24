<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><sitemesh:write property="title" /></title>

  <jsp:include page="/WEB-INF/views/include/style.jsp" />
  <sitemesh:write property="head" />
  
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- navigation -->
  <%@ include file="/WEB-INF/views/include/navigation.jsp" %>
  	
  <!-- aside -->
  <jsp:include page="/WEB-INF/views/include/aside.jsp" flush="false"/> 


  <sitemesh:write property="body" />


 <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->  

<jsp:include page="/WEB-INF/views/include/js.jsp" />

</body>
</html>




