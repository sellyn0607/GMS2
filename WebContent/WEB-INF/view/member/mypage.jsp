
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<table style="margin:100px 450px 0px" >
	<tr>
		<td rowspan="3" colspan="2"><img src="${img}/home/test.jpg" alt="" /></td>
		<td>ID</td>
		<td>${user.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${user.name}</td>
		
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${user.password}</td>
		
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀명</td>
		<td>${user.teamId}</td>
		
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>역할</td>
		<td>${user.roll}</td>
	</tr>
</table>
<br> <button id = "myPageUpdate" style="margin-left: 63%">Update 이동</button>
<script>
document.getElementById('myPageUpdate').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'member',
	action : 'move',
	page : 'updateForm'
	
	})
});
</script>
</body>
</html>