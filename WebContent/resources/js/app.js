var router= (()=> {
	return {move :x=> {
			location.href = x[0]+"/"+x[1]+".do?action="+x[2]+"&page="+x[3]		
	}};
})();
var service =(()=>{
	return {
		loginValiation : x=>{
			if(x.userid===""){
				alert(x);
				alert("ID 를 입력해주세요 ");	
				return false;
			}
			else if (x.password===""){
				alert("비밀번호를 입력해주세요");
				return false;
			}else{
				return true;
			}
		}
	};
})();

	// anoymous functions
	function Member() {
		var userid,password,ssn;
		
		this.setUserid = function(x){
			this.userid = x;
		}
		this.setPassword = function(y){
			this.password = y;
		}
		this.setSsn = function(z){
			this.ssn = z;
		}
	
		this.getUserid = function(){
			return this.userid;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.loginValiation= function() {
			
			if(this.userid===""){
				alert("id비어있음");	
				return false;
			}
			else if (this.password===""){
				alert("pw비어있음");
				return false;
			}else{
				return true;
			}
		}


		//function(){}();
		//(function(){})(); // Goofy
		(function(){}()); // Groovy
		
	};
	