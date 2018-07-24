<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
			<ul id="menu">
				<li><a onclick="move2('member','move','index')">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a onclick="move2('member','move','findByTeamIdForm')">회원 TEAMID 조회</a></li>
				<li><a onclick="move2('member','list','listForm')">회원 List</a></li>
			</ul>
		</div>
<script>
function move2(domain,action,page){
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
}
</script>