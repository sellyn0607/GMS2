<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<h3>아이디찾기</h3>
<form id="findByIdForm">
아이디 : <input id="userid" type="text" name="userid"/><br />
<input type="hidden" name="action" value="findid"/>
<input type="hidden" name="page" value="findByIdResult"/>
<input type="button" id="findByIdButt" value="확인"/>
</form>
<script>
	document.getElementById('findByIdButt').addEventListener('click',function(){
	
		var form = document.getElementById('findByIdForm');
		var x = service.nullChecker([form.userid.value]);
		if(x.checker){
			form.action="${context}/member.do";
			form.method="get";
			form.submit();
		}else
			alert(x.text);
		
		
	});
</script>
</body>
</html>