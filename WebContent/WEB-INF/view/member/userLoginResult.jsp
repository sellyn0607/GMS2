<%@page import="dao.MemberDAOImpl"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="service.*" %>
<%@page import="domain.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<%
	MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("userid"));
	m.setPassword(request.getParameter("pw"));
  	m= MemberServiceImpl.getInstance().login(m);
  	
  	if(m.getSsn().equals("999")){
  		%><h3>로그인에 실패하셨습니다</h3><%
  	}else{
  		%>
  		<h3> ID : <%=m.getUserid() %></h3>
  		<h3> 비밀번호 :<%=m.getPassword() %></h3><%
  	}
	
%>

	
</body>
</html>