<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<div id="user">
<h3>회원탈퇴</h3>
<form id="deleteForm" style="border:1px solid black">
아이디 : ${user.userid}<br /> <br>
비밀번호 : <br /> &nbsp;<input type="password" id="pw" name ="pw" /><br />
<br />
&nbsp; <input id="deleteButt" type="button" value="확인"/>
</form>
</div>
	<script>
	document.getElementById('deleteButt').addEventListener('click',function(){
		
		var form = document.getElementById('deleteForm');
		var x = service.nullChecker([form.pw.value]);
		if(x.checker){
			
			if(form.pw.value==='${user.password}'){
				form.action="${context}/member.do";
				form.method="post";
				/* var node = document.createElement('input');
				form.appendChild(node);
				node.innerHTML = '<input type="hidden" name="action" value="delete"/>' */
					var node = document.createElement('input');
					node.setAttribute('type','hidden');
					node.setAttribute('name','action');
					node.setAttribute('value','delete');
					form.appendChild(node);
				
				form.submit();
				alert("회원탈퇴에 성공하셨습니다.");
				
			}else{
				alert("비밀번호가 틀리셨습니다.");
			}
			
		}else
			alert(x.text);
		
		
	});
	</script>

</body>
</html>