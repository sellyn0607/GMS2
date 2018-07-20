<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% String ctx = application.getContextPath(); %>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style>
	#user{margin: 150px auto;width:250px;}
	</style>
</head>
<body>
	<div id="user">
	<h1>로그인</h1>
	<form action="<%=ctx %>/member.do" style="border:1px solid black;">
	 아이디 <br />
	 <input type="text" name="userid" ><br><Br>
	 비밀번호<br>
	 <input type="password" name="pw" ><br><br>
	 <input type="hidden" name="action" value="login" />
	 <input type="hidden" name="page" value="mypage"/>
	<input type="submit" value="로그인"><br>
	</form></div>
</body>
</html>