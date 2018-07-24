<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp"></jsp:include>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/titleBox.jsp"/>
		<jsp:include page="common/loginBox.jsp" />
		<jsp:include page="common/menuBox.jsp" />
	</div> <!-- header end -->
		<jsp:include page="common/contentBox.jsp" />
	</div>
	<jsp:include page="common/footer.jsp" />

<script>

function move(domain,action,page){
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
}
function sendForm() {
 	 alert("하이");
       return true;
   
}
	
</script>

</body>
</html>