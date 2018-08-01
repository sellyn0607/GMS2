
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<table style="margin:100px 450px 0px" >
	<tr>
		<td rowspan="3" colspan="2"><img src="${img}/home/test.jpg" alt="" /></td>
		<td>ID</td>
		<td>${findId.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${findId.name}</td>
		
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${findId.password}</td>
		
	</tr>
	<tr>
		<td>나이</td>
		<td>${findId.age}</td>
		<td>팀명</td>
		<td>${findId.teamId}</td>
		
	</tr>
	<tr>
		<td>성별</td>
		<td>${findId.gender}</td>
		<td>역할</td>
		<td>${findId.roll}</td>
	</tr>
</table>
<br> <button id = "myPageUpdate" style="margin-left: 54%">Update 이동</button>
	<button id = "myPageDelete" style="margin-left: 2%"> 회원탈퇴 </button>
<script>
document.getElementById('myPageUpdate').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'member',
	action : 'move',
	page : 'updateForm'
	
	})
});
document.getElementById('myPageDelete').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'member',
	action : 'move',
	page : 'deleteForm'
	
	})
});
</script>
</body>
</html>