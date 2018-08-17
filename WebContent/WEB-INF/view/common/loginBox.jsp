<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="Login-box">
	
	<c:choose>
		<c:when test="${match eq 'TRUE'}">
		<button type = "button" id="logoutButt" >로그아웃</button>
		</c:when>
		<c:otherwise>
			<button type = "button" id="moveLoginForm" >로그인</button>
			 &nbsp; &nbsp; <button type = "button" id="joinLoginForm" >회원가입</button>
		</c:otherwise>
	</c:choose>
		</div>
