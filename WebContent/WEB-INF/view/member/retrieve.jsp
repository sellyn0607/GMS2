<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table style="margin:100px 450px 0px" >
	<tr>
		<td rowspan="3" colspan="2" >
		<img src="${img}/${imgfile}" alt="" style="width:400px; height: 300px"/>
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
	<button id = "myPageUpdate" style="margin-left:52%;">Update 이동</button>
	<button id = "myPageDelete" style="margin-left: 2%"> 회원탈퇴 </button>

