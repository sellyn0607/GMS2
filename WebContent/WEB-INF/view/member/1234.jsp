<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String ctx = application.getContextPath(); %>
    <%@ page import="java.util.*" %>
    <%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
<head>
<% MemberBean user = (MemberBean)request.getAttribute("user"); %>
	<meta charset="UTF-8" />
	<title>Document</title>

</head>
<body>
	<table id="tb">
		<tr class="he-50">
			<th colspan="2">GMS</th>
		</tr>
		<tr class="height-500px">
			<td><a href="../home/hello.html"><img src="../../img/mypage/img_girl.jpg" alt="" /></a></td>
			<td id="wt">님 <br><a href="../../main.jsp"> 로그아웃</a>
			</td>
		</tr>
		<tr class="he-50">
			<td colspan="2 "><%=user %></td>
		</tr>
	</table>
</body>
</html>