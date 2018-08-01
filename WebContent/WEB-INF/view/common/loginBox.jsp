<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="Login-box">
			<button id="moveLoginForm" >LOGIN</button>
			 &nbsp; &nbsp; <button id="joinLoginForm" >JOIN</button>
		</div>
<script>
document.getElementById('moveLoginForm').addEventListener('click',function(){ // 콜백함수 .....
	router.move({context : '${context}',domain : 'member', action : 'move', page : 'userLoginForm'});
});
document.getElementById('joinLoginForm').addEventListener('click',function(){ // 콜백함수 .....
	router.move({context : '${context}',domain : 'member',action : 'move',page : 'joinForm'});
});
</script>