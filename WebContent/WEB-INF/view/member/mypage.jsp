<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    <%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
  <% String user = (String)request.getAttribute("user"); %>
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

	<h3><%=user %> 님</h3> 

</body>
</html>