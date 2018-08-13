<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table style="margin:100px 450px 0px" >
	<tr>
		<td rowspan="3" colspan="2">
		<img src="${img}/home/test.jpg" alt="" />
		</td>
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
<br> 
	<button id ="maingo" type="button" style="margin-left:52%;">메인페이지</button>	
	<button id = "myPageUpdate" style="margin-left: 2%">Update 이동</button>
	<button id = "myPageDelete" style="margin-left: 2%"> 회원탈퇴 </button>
	
<script>
document.getElementById('maingo').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'common'
	})
});
document.getElementById('myPageUpdate').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'member',
	action : 'move',
	page : 'modify'
	
	})
});
document.getElementById('myPageDelete').addEventListener('click',function(){
	router.move({context : '${context}',
	domain : 'member',
	action : 'move',
	page : 'remove'
	
	})
});
</script>
