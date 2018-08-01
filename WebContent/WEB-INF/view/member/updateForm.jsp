<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<h3 align="center">비밀번호 변경</h3>
<form id ="upDateId">
<table style="margin:100px 450px 0px" >
	<tr>
		<td rowspan="3" colspan="2"><img src="${img}/home/test.jpg" alt="" /></td>
		<td>ID</td>
		<td>${user.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${user.name}</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id ="pw" name="password" /></td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀명</td>
		<td><select id="teamId" name="teamId"><option value="ATEAM" >ATEAM</option><option value="CTEAM">CTEAM</option><option value="HTEAM">HTEAM</option>
			<option value="STEAM">STEAM</option></select></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>역할</td>
		<td><!-- <select name="roll"><option value="팀장">팀장</option><option value="팀원">팀원</option><option value="민폐">민폐</option>
			</select> -->
			 <input type="radio" id="roll_1" name="roll" value="팀장"/>팀장 <input type="radio" name="roll" id="roll_2" value="팀원"/>팀원
			</td>
	</tr>
</table>
	<%-- <input type="hidden" name="userid" value="${user.userid }" /> --%>
	<!-- <input type="hidden" name="action" value="update"/> -->
	
	<br /><input id="updateBt" style="margin-left: 70%; width=100px "  type="button" value="수정" />
</form>
<script>
var form = document.getElementById('upDateId');
var team = document.getElementById('teamId');
var roll = document.getElementById('roll');
for(var i=0; i<team.options.length;i++){
	if(team.options[i].value==='${user.teamId}'){
		team.options[i].setAttribute("selected","selected");
	}
}
for(var i=1;i<=2; i++){
	if(document.getElementById('roll_'+i).value==='${user.roll}'){
		document.getElementById('roll_'+i).checked = true;
	}
}


document.getElementById('updateBt').addEventListener('click',function(){
	
	var x = service.nullChecker(
			[form.pw.value]);
	if(x.checker){
	form.action="${context}/member.do";
	form.method="post";
	var node = document.createElement('input');
	form.appendChild(node);
	node.innerHTML = '<input type="hidden" name="action" value="update"/>'
	form.submit();
	alert("회원정보가 수정되었습니다.");
	}else{
		alert(x.text);
	}
	
});

</script>
</body>
</html>



