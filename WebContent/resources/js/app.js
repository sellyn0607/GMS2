function Common() {
		this.move = function(t,domain,action,page) {
			location.href = t+"/"+domain+".do?action="+action+"&page="+page;		
	}
};
	// anoymous functions
	function member() {
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
	};
	