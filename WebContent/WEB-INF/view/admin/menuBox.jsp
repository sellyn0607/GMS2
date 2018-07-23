<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=application.getContextPath() %>" />
<div id="menu-box">
			<ul id="menu">
				<li><a href="${ctx}/member.do?action=move&page=index">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a href="${ctx}/member.do?action=move&page=findByTeamIdForm">회원 TEAMID 조회</a></li>
				<li><a href="${ctx}/member.do?action=list&page=listForm">회원 List</a></li>
			</ul>
		</div>