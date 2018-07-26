<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="Login-box">
			<a id="moveLoginForm" > LOGIN</a>
			 &nbsp; &nbsp; &nbsp; <a id="joinLoginForm">JOIN</a>
		</div>
<script>
document.getElementById('moveLoginForm').addEventListener('click',function(){ // 콜백함수 .....
	alert("로그인");
	new Common().move('${context}','member','move','userLoginForm');
});
document.getElementById('joinLoginForm').addEventListener('click',function(){ // 콜백함수 .....
	alert("조인");
	new Common().move('${context}','member','move','joinForm');
});
</script>