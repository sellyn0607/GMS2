<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% String ctx = application.getContextPath(); %>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디찾기</title>
</head>
<body>
<h3>아이디찾기</h3>
<form action="<%=ctx%>/member.do">
아이디 : <input type="text" name="userid"/><br />
<input type="hidden" name="action" value="findid"/>
<input type="hidden" name="page" value="findById"/>
<input type="submit" value="확인"/>
</form>
</body>
</html>