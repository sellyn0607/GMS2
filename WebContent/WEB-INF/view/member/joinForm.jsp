<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<style>
#user {
	margin: 150px auto;
	width: 250px;
}
</style>

<body>
	<div id="user">
		<h2>회원 가입</h2>
		<<form id="joinForm"  style="border:1px solid black" name="joinForm"> 
			아이디 : <input type="text" name="userid" maxlength="10" size="9">
		<br> 비밀번호 : <input type="password" name="pw" maxlength="20"size="12"> <br> 
			이름 : <input type="text" name="name"
			maxlength="5" size="8"><br> 명단 : <input type="radio"
			name="roll" value="팀장" />팀장 <input type="radio" name="roll"value="팀원" />
			팀원<br> 팀ID : <select name="team_id"><option
				value="ATEAM">ATEAM</option>
			<option value="CTEAM">CTEAM</option>
			<option value="HTEAM">HTEAM</option>
			<option value="STEAM">STEAM</option></select><br> 수강 목록 : <input
			type="checkbox" name="subject" value="java" checked="checked" /> Java
		<input type="checkbox" name="subject" value="JSP" /> JSP <br /> <input
			type="checkbox" name="subject" value="PHP"> PHP <input
			type="checkbox" name="subject" value=NodeJS /> NodeJS <input
			type="checkbox" name="subject" value="Linux" /> Linux <br /> <input
			type="checkbox" name="subject" value="HTML" /> HTML <input
			type="checkbox" name="subject" value="Spring" /> Spring <br /> 생년
		월일 : <input type="text" name="ssn1" maxlength="6" size="7"> -
		<input type="text" name="ssn2" maxlength="1" size="1"> <br>

		<input id="joinButt" type="button" value="회원가입">
		 </form> 
	</div>
	<script>
	 document.getElementById('joinButt').addEventListener(
				'click',
				function() {

					var form = document.getElementById('joinForm');
					var x = service.nullChecker([ form.userid.value,
							form.pw.value, form.name.value, form.roll.value,
							form.team_id.value, form.ssn1.value,
							form.ssn2.value ]);
					if (x.checker) {
						form.action = "${context}/member.do";
						form.method = "post";
						member.join([ form.ssn2.value, form.ssn1.value ]);
						var arr = {
							name : [ 'action', 'gender', 'age' ],
							value : [ 'join', member.getGender(),
									member.getAge() ]
						};

						/* var j=[{name : 'action',value : 'join'},
							{name : 'gender',value : member.getGender()},
							{name : 'age',value : member.getAge()}]; */

						/* var arr=['action','gender','age'];
						var arr2=['join','','']; */

						for (var i = 0; i < 3; i++) {
							var node = document.createElement('input');
							node.setAttribute('type', 'hidden');
							node.setAttribute('name', arr.name[i]);
							node.setAttribute('value', arr.value[i]);
							form.appendChild(node);
						}

						/*form.gender.value = member.getGender();
						form.age.value = member.getAge(); */

						form.submit();

					} else {
						alert(x.text);

					}
				}); 
	

					
	</script>
</body>
</html>