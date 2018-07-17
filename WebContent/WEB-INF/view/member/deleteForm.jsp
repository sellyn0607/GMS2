<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% String ctx = application.getContextPath(); %>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원탈퇴</title>
</head>
<body>
<h3>회원탈퇴</h3>
<form action="<%=ctx %>/member.do">
아이디 : <input type="text" name="userid"/><br />
비밀번호 : <input type="password" name ="pw" /><br />
<input type="hidden" name="action" value="move"/>
<input type="hidden" name="page" value="deleteResult"/>
<input type="submit" value="확인"/>

</form>



</body>
</html>