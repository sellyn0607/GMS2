<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
<div id="content-box">
	<div id="contentBoxSearch" style="text-align: left; margin-left: 315px;"> 
	<select id="contentSelect" name="contentSelect" >
			<option value="none">검색 조건</option>
			<option value="findid">아이디</option>
			<option value="name">이 름</option>
			<option value="teamid">팀명</option></select>
	<input type="text" id='searchText' placeholder="검색어 입력"  /> <button id ="searchButt" style="height :24px; width:24px; 
	background-image: url('${img}/home/bb.jpg')" ></button>
	</div><br>
		<table id="contentBoxTab" style="width:55% ">	
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
			<tr>
				<td colspan="6" style="height: 30px">
				전체 회원수 :${count} <br />
					<c:forEach begin="${beginPage}" end="${endPage}"  varStatus="i">
					
				<span>
					<a class="index2" id="${i.index}">${i.index}</a>
				</span>
				</c:forEach>
				<%
				int count = (int)request.getSession().getAttribute("count");
				int endPage = (int)request.getSession().getAttribute("endPage");
				if(endPage <= count){
					%>
					<span><a id="nextPageButt">다음▶</a></span>
					<%
				}
				%>
				 
				</td>
			</tr>
		</table>
		
	
		</div></div>
<script>

admin.main('${context}');




	
	
	
/* <a href="${context}/admin.do?action=findid&page=memberDetail&userid=
	${member.getUserid()}" style="cursor: pointer;">${member.getName() }</a> */
</script>