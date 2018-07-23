
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=application.getContextPath() %>" />


<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="${ctx}/resources/css/style.css" />
	<title>Document</title>
	
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="title-box">
			<h1> GRADE MANAGEMENT SYSTEM</h1>
		</div>
		<div id="Login-box">
			<a href="${ctx}/member.do?action=move&page=index">LOGOUT</a> 
		</div>
		
		<div id="menu-box">
			<ul id="menu">
				<li><a href="">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a href="${ctx}/admin.do?action=move&page=main">ADMIN</a></li>
				<li><a href="${ctx}/member.do?action=move&page=findByIdForm">회원ID검색</a></li>
				
				
			</ul>
		</div>
		
	</div> <!-- header end -->
	<div id="content">
		<div id="content-box">
		<h1>WELCOM MY HOMEPAGE</h1>
		</div>
	</div>
	<div id="footer"> 주소 : </div>
</div>
	
</body>
</html>