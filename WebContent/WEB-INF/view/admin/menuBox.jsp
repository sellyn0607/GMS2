%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box" style="text-align: right;">
			<ul id="menu">
				<li ><a id="homeButt">HOME</a></li>
				<li ><a href="">ABOUT</a></li>
				<li ><a id="findTeamIdButt">회원 TEAMID 조회</a></li>
				<li ><a id="listButt">회원 List</a></li>
			</ul>
		</div>
<script>
document.getElementById('homeButt').addEventListener('click',function(){ // 콜백함수 .....
	
	router.move({
		context : '${context}' , domain : 'common'
	})
});

document.getElementById('findTeamIdButt').addEventListener('click',function(){ // 콜백함수 .....
	
	router.move({
		context : '${context}' , domain : 'member' , action : 'move', page : 'findByTeamIdForm'
	})
});

document.getElementById('listButt').addEventListener('click',function(){ // 콜백함수 .....
	
	router.move({
		context : '${context}' , domain : 'member' , action : 'list', page : 'listForm'
	})
});


</script>