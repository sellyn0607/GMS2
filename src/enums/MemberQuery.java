package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBAER,SSN_LIST,TEST,TEST2,COUNT_MEMBER,UPDATE_MEMBER,UPDATE_MEMBER2,DELETE_MEMBER,
	SELECT_ALLMEMBER,DELETE_MEMBER2,FIND_BY_ID,FIND_BY_TEAMID,FIND_BY_NAME;
	@Override
	public String toString() {
		String query = "";
		
		switch (this) {
		case LOGIN: 
			query="SELECT userid, teamid, NAME, SSN,ROLL"+
					"  , PASSWORD FROM MEMBER WHERE userid LIKE '%s' and PASSWORD LIKE '%s'";
			break;
		case INSERT_MEMBAER:
			query="insert into member(userid,password,name,ssn,age,roll,teamid,gender) values('%s','%s','%s','%s','%s','%s','%s','%s') ";
			break;
		case SSN_LIST:
			query="select mem_age from teamw "; break;
			
		case TEST:
			query="update member set SSN='%s' where mem_id like '%s'"; break;
		case TEST2:
			query="update member set AGE='%s' where mem_id like '%s'"; break;
		case COUNT_MEMBER:
			query="select count(*) AS count FROM MEMBER"; break;
		case UPDATE_MEMBER:
			query="update member set PASSWORD='%s',roll='%s',teamid='%s' where userid like '%s'"; 
			break;
		case UPDATE_MEMBER2:
			query="select userid,password from member where userid like '%s' and password like '%s'";
			break;
		case DELETE_MEMBER:
			query="delete from member where userid like '%s'";
			break;
		
		case SELECT_ALLMEMBER:
			query="select userid,SSN,name,password,roll,teamid,age,gender from member";
			break;
		case FIND_BY_ID :
			query = "select userid,SSN,name,password,roll,teamid,age,gender from member where userid like '%s'";
			break;
		case FIND_BY_TEAMID:
			query = "select userid,SSN,name,password,roll,teamid,age,gender from member where teamid like '%s'";
			break;
			
		case FIND_BY_NAME:
			query = "select userid,SSN,name,password,roll,teamid,age,gender from member where name like '%s'";
			break;
		default:
			break;
		}
		return query;
	}
	

}
