<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
<div id="content-box">

		<table id="contentBoxTab" >
			<tr id="contentBoxMeta">
				<th>아이디</th>
				<th>이 름</th>
				<th>나 이</th>
				<th>성 별</th>
				<th>역 할</th>
				<th>팀명</th>
			</tr>
			<c:forEach items="${list}" var="member" >
			<tr>
				<td>${member.userid}</td>
				<td><a class="userName" id="${member.userid}"> ${member.name}</a></td>
				<td>${member.age}</td>
				<td>${member.gender}</td>
				<td>${member.roll}</td>
				<td>${member.teamId}</td>
			</tr></c:forEach>
		</table>
		
	
		</div></div>
<script>
	/* document.getElementById('contentBoxMeta').className='bgcolorisYellow'; */
	
var x = document.querySelectorAll('.userName');
for (i in x){
	x[i].style.color = 'blue';
	x[i].style.cursor = 'pointer';
	x[i].addEventListener('click',function(){
		location.href='${context}/admin.do?action=findid&page=memberDetail&userid='+this.getAttribute('id');
	
		
	});
}

	
	
	
/* <a href="${context}/admin.do?action=findid&page=memberDetail&userid=
	${member.getUserid()}" style="cursor: pointer;">${member.getName() }</a> */
</script>