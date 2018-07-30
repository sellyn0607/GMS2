<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% String ctx = application.getContextPath(); %>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<h3>비밀번호 변경</h3>
<form action="<%=ctx%>/member.do">
아이디 : <input type="text" name="userid"/><br />
비밀번호 : <input type="password" name ="pw" placeholder="${uesr.password}]"/><br />
새 비밀번호 입력 : <input type="password" name ="npw" />
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="page" value="updateResult"/>
<input id = "updateBt" type="button" value="확인"/>

</form>
<script>
document.getElementById('updateBt').addEventListener('click',function(){
	alert("수정확인");
	
	
});

</script>
</body>
</html>



