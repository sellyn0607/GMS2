<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h3 align="center">비밀번호 변경</h3>
<form id ="upDateId">
<table style="margin:auto" >
	<tr>
		<td rowspan="3" colspan="2">
		<img src="${img}/home/test.jpg" alt="" />
		</td>
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
		<td>
			 <input type="radio" id="roll_1" name="roll" value="팀장"/>팀장 <br />
			 <input type="radio" name="roll" id="roll_2" value="팀원"/>팀원<br />
			 <input type="radio" name="roll" id="roll_3" value="프론트개발"/>프론트개발<br />
			 <input type="radio" name="roll" id="roll_4" value="백단개발"/>백단개발<br />
			 <input type="radio" name="roll" id="roll_5" value="민폐"/>민폐
			</td>
	</tr>
</table>
	
	<br /><input id="updateBt" style="margin-left: 70%; width=100px "  type="button" value="수정" />
</form>
	<form method="POST" enctype="multipart/form-data" action="${context}/member.do?action=fileupload&page=retrieve" style="margin-left: 400px">
  		파일업로드 : <input type="file" name="upfile"><br/>
	  <input type="submit" value="파일업로드">
	 
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
for(var i=1;i<=5; i++){
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
	node.innerHTML = '<input type="hidden" name="action" value="modify"/>'
		var node1 = document.createElement('input');
	form.appendChild(node1);
	node1.innerHTML = '<input type="hidden" name="page" value="retrieve"/>'
	form.submit();
	alert("회원정보가 수정되었습니다.");
	}else{
		alert(x.text);
	}
	
});

</script>



