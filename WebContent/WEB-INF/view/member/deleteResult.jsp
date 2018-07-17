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
	m.setPassword(request.getParameter("pw"));
	MemberServiceImpl.getInstance().delete(m);
	
  	
  	%>
  	<h2><a href="<%=ctx %>/member.do?action=move&page=userLoginFrom">회원이 삭제되었습니다</a></h2>
</body>
</html>