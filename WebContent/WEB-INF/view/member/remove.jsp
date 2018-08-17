<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="user">
<h3>회원탈퇴</h3>
<form id="deleteForm" style="border:1px solid black">
아이디 : ${user.userid}<br /> <br>
비밀번호 : <br /> &nbsp;<input type="password" id="${user.password}" name ="pw" /><br />
<br />
&nbsp; <input id="deleteButt" type="button" value="확인"/>
</form>
</div>
