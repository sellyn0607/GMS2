<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="domain.*" %>
<%@ page import ="service.*" %>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>업데이트결과창</title>
</head>
<body>
<% MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("userid"));
	m.setPassword(String.format("%s/%s",request.getParameter("pw"), request.getParameter("npw")));

	MemberServiceImpl.getInstance().update(m);

  	
  	%>
  	<h2><a href="../login/mypage.jsp">비밀번호가 변경되었습니다</a></h2>
</body>
</html>