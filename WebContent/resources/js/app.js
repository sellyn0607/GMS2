"use strict";
var router= (()=> {
	return {move :x=> {
			location.href = x.context+"/"+x.domain+".do?action="+x.action+"&page="+x.page		
	}};
})();
var service =(()=>{
	return {
		nullChecker : x=>{
			var i= 0 ; 
			var j = { checker : true, text : '필수입력값이 없습니다.'};
			for(i in x){
				if(x[i]===''){
					j.checker = false 
				}
			}
			return j;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
			if (arr.indexOf(cName) == -1){
				dom.className += " "+ cName;
			}
		}
	};
	
})();

var admin = (()=>{
	return {
	check : (x) =>{
		router.move({context : x , domain : 'admin', action : 'list', page : 'main'});
		/*var isAdmin = confirm('관리자입니까?');
		if(isAdmin){
			
			var password=prompt('관리자 비밀번호를 입력하세요');
			
			if(password==1){
				router.move({context : x , domain : 'admin', action : 'list', page : 'main'});
			}
		}else{
			alert('관리자만 접근이 허용됩니다.');
		}*/
	},
	main : x=>{
		
		document.getElementById('searchButt').addEventListener('click',function(){
			
			var searchV = document.getElementById('contentSelect').value;
			var searchT = document.getElementById('searchText').value;
			
			if(searchV==='none'){
				alert("검색조건을 선택해주세요 .");
				location.href=x+'/admin.do?action=findid';
			}else {
				if(searchV==='findid'){
				location.href=x+'/admin.do?action=findid&page=memberDetail&userid='+
						searchT;
				}else{
					location.href=x+'/admin.do?action=findsearch&page=main&searchOption='+searchV
					+'&searchText='+searchT;
				}
			}
			
			
		});

		service.addClass(document.getElementById('contentSelect'),'height22px ');
		
		for (var i of document.querySelectorAll('.userName')){
			service.addClass(i,'cursor fontColorBlue');
			
			i.addEventListener('click',function(){
				location.href=x+'/admin.do?action=findid&page=memberDetail&userid='+this.getAttribute('id');
			});
		}

		
	}
	
};})();

	var member=(()=> {
		var _userid,_password,_ssn,_age,_gender;
		
		var setUserid = (userid)=>{this._userid = userid;}
		var setPassword = (password)=>{this._password = password;}
		var setSsn = (ssn)=>{this._ssn = ssn;}
		var setAge = (age)=>{
			var d = new Date();
			d=(d.getFullYear()-age.substring(0,2))+1;
			
			this._age = (String(d)).substring(2,4);
		
		//119-Integer.parseInt(member.getSsn().substring(0,2)
		 
		}
		var setGender = (gender)=>{
			var s;
		switch(gender){
		case '1' : s="남자"; break;
		case '2' : s="여자"; break;
		
		}
		this._gender=s;
		}
		
		var getUserid = ()=>{return this._userid;}
		var getPassword = ()=>{return this._password;}
		var getSsn = ()=>{return this._ssn;}
		var getAge = ()=>{return this._age;}
		var getGender = ()=>{return this._gender;}
		
		return{
			setUserid : setUserid,
			setPassword : setPassword,
			setSsn : setSsn,
			getUserid : getUserid,
			getPassword : getPassword,
			getSsn : getSsn,
			setAge : setAge,
			setGender : setGender,
			getAge : getAge,
			getGender : getGender,
			join : x=>{
				member.setGender(x[0]);
				member.setAge(x[1]);
			}
			
		}})();
		

	
	
	
	