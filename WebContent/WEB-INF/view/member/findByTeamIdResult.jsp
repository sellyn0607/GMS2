<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="domain.*" %>
<%@ page import ="service.*" %>
<%@ page import = "java.util.*" %>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디 찾기</title>
	<style>
	.table,tr,td,th{
		border: 1px solid black;	border-collapse: collapse;	text-align:center; 	margin: 0 auto 

	}
	</style>
</head>
<body>
<% 
	List<MemberBean> lst = MemberServiceImpl.getInstance().findBySearch(request.getParameter("team_id"));
  	%>
  	<table class="table">
 	<tr >
 		
 		<th>ID</th>
 		<th>TeamID</th>
 		<th>이름</th>
 		
 	</tr>
 	<% for(MemberBean m : lst){
	 %>
 	<tr>
 		<td><%= m.getUserid() %></td>
 		<td><%= m.getTeamId() %></td>
 		<td><%= m.getName()%></td>
 		
 	</tr><%} %>
 	
 </table>
  	<h2><a href="../login/mypage.jsp">메인화면으로</a></h2>
</body>
</html>