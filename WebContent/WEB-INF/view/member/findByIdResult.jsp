<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="domain.*" %>
<%@ page import ="service.*" %>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디 찾기</title>
</head>
<body>
<% MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("userid"));
	m=MemberServiceImpl.getInstance().findById(m);
  	%>
  	<h3><%=m %></h3>
  	<h2><a href="../login/mypage.jsp">메인화면으로</a></h2>
</body>
</html>