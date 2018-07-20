<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입</title>
	<style>#user{margin: 150px auto;width:250px;}</style>
</head>
<body>
<div id="user">
	<h2> 회원 가입 </h2>
	<form action="<%=ctx %>/member.do" style="border:1px solid black">
	아이디 : <input type="text" name="userid" maxlength= "10"size="9">  <br>
	비밀번호 : <input type="password" name="pw" maxlength= "20" size="12"> <br>
	이름 : <input type="text" name="name" maxlength="5" size="8"><br>
	명단 : <input type="radio" name="roll" value="팀장"/>팀장 <input type="radio" name="roll" value="팀원"/>팀원<br>
	팀ID : <select name="team_id"><option value="ATEAM">ATEAM</option><option value="CTEAM">CTEAM</option><option value="HTEAM">HTEAM</option>
			<option value="STEAM">STEAM</option></select><br> 
	생년 월일 : <input type="text" name="ssn1" maxlength= "6" size="7"> - <input type="text" name="ssn2" maxlength="1" size="1"><br>
	<input type="hidden" name="action" value="join"/>
	<input type="hidden" name="page" value="userLoginForm"/>
	<input type="submit" value="회원가입" >
	
	</form></div>
	
</body>
</html>