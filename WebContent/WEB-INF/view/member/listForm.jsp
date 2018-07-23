<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
<% List<MemberBean> lst = (List)request.getAttribute("list");%>

	<meta charset="UTF-8" />
	<title>리스트</title>
	<style>
	.table,tr,td,th{
		border: 1px solid black;	border-collapse: collapse;	text-align:center; 	margin: 0 auto 

	}
	</style>
</head>
<body>

<table class="table">
 	<tr >
 		<th>ID</th>
 		<th>이름</th>
 		<th>비밀번호</th>
 		<th>나이</th>
 	</tr>
 	<% for(MemberBean m : lst){
	 %>
 	<tr>
 		<td><%= m.getUserid() %></td>
 		<td><%= m.getName()%></td>
 		<td><%= m.getPassword() %></td>
 		<td><%= m.getAge() %></td>
 	</tr><%} %>
 	
 </table>
 
 
 </body>
</html>