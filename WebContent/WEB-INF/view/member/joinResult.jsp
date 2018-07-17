<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=" domain.* " %>
<%@ page import=" service.* "%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 결과창</title>
</head>
<%
	MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("userid"));
	m.setPassword(request.getParameter("pw"));
	m.setName(request.getParameter("name"));
	m.setSsn(request.getParameter("ssn1"));
	m.setRoll(request.getParameter("roll"));
	m.setTeamId(request.getParameter("team_id"));
  	MemberServiceImpl.getInstance().createMember(m);
  
 
 %>
 <h2><a href="<%=ctx %>/member.do?action=move&page=userLoginFrom">회원가입에 성공하셨습니다.</a></h2>
</html>