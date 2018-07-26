<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
			<ul id="menu">
				<li><a href="">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a id="adminButt">ADMIN</a></li>
				<li><a id="findIdButt">회원ID검색</a></li>
				
				
			</ul>
			<script>
			document.getElementById('adminButt').addEventListener('click',function(){ // 콜백함수 .....
				
				new Common().move('${context}','admin','move','main');
			});
			document.getElementById('findIdButt').addEventListener('click',function(){ // 콜백함수 .....
				
				new Common().move('${context}','member','move','findByIdForm');
			});
			
			</script>
		</div>