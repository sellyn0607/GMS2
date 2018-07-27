var router= (()=> {
	return {move :x=> {
			location.href = x[0]+"/"+x[1]+".do?action="+x[2]+"&page="+x[3]		
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
			/*var ok = true ;
			for(var y in x){
				if(x[y]===""){
					alert("필수 입력칸이 비어있습니다");
					return ok;
				}
			}
			
			return ok;*/
		}
		
	};
})();

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
		

	
	
	
	