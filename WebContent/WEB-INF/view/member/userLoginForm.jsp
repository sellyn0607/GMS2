<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="user">
	<h1>로그인</h1>
	<form id="loginForm"  style="border:1px solid black;">
	&nbsp; 아이디 <br />
	 &nbsp;<input type="text" name="userid" ><br><Br>
	&nbsp; 비밀번호<br />
	&nbsp; <input type="password" name="pw" ><br><br>
	 <input type="hidden" name="action" value="login" />
	 <input type="hidden" name="page" value="mypage"/>
	<input id="loginFormBtn" type="button" value="로그인"><br>
	</form></div>
	<script>
	document.getElementById('loginFormBtn').addEventListener('click',function(){
		/* var member = new Member(); */
		var form = document.getElementById('loginForm');
	/* 	member.setUserid(form.userid.value);
		member.setPassword(form.pw.value); */
		var x = service.nullChecker([form.userid.value,form.pw.value]);
		if(x.checker){
			form.action="${context}/member.do";
			form.method="post";
			form.submit();
		}else
			alert(x.text);
		
		
	});
</script>
</body>
</html>