<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <% List<MemberBean> lst = (List)request.getAttribute("list");%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<h3>리스트</h3>


 <table style="margin: 0;">
 	<tr>
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