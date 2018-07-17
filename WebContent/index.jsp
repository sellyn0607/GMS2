
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="css/style.css" />
	<title>Document</title>

	
</head>

<body>
	<h3>현재 회원수는 </h3>
	<table id="tb" >
		<tr class="he-50">
			<th colspan="2">GMS</th>
		</tr>
		<tr class="height-500px">
			<td><img src="img/mypage/img_girl.jpg" alt="" /></td>
			<td id="wt">
			<ul>
				<li><a href="<%=ctx %>/member.do?action=move&page=joinForm">회원가입</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=userLoginForm">사용자 로그인</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=admin_login">관리자로그인</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=listForm">회원리스트</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=findByIdForm">ID찾기</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=findByTeamIdForm">팀이름찾기</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=updateForm">비밀번호 변경</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=deleteForm">회원탈퇴</a></li>
				
				<li></li>
			</ul>
		
			</td>
		</tr>
		<tr class="he-50">
			<td colspan="2 ">주소</td>
		</tr>
	</table>
</body>
</html>