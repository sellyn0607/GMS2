<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<% String ctx = application.getContextPath(); %>
<head>
	<meta charset="UTF-8" />
	<title>팀ID찾기</title>
</head>
<body>

<form action="<%=ctx%>/member.do">
팀ID <input type="text" name="team_id"/><br />
<input type="hidden" name="action" value="findteamid"/>
<input type="hidden" name="page" value="findByTeamId"/>
<input type="submit" value="확인"/>
</form>
</body>
</html>