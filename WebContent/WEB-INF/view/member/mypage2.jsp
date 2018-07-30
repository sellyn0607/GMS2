
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<div id="Login-box">
			<a href="${context}/member.do?action=move&page=index">${user.name} 님 LOGOUT</a> 
		</div>
	<jsp:include page="../common/menuBox.jsp"/>
	</div> <!-- header end -->
	<div id="content">
<div id="content-box">
		<h1>WELCOM MY HOMEPAGE</h1>
		</div>
		<%-- <div id="content-img">
		<img src="${context}/resources/img/home/test.jpg" alt=""  /></div> --%>
		<h1>${user.userid}</h1> <br />
		<h1>${user.password}</h1> <br />
		<h1>${user.name}</h1> <br />
		<h1>${user.ssn}</h1> <br />
		<h1>${user.age}</h1> <br />
		<h1>${user.teamId}</h1> <br />
		</div>
	<jsp:include page="../common/footer.jsp"/>
</div>
	<script>
	
	</script>
</body>
</html>