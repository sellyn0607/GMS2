package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBAER,SSN_LIST,TEST,TEST2,COUNT_MEMBER,UPDATE_MEMBER,UPDATE_MEMBER2,DELETE_MEMBER,
	SELECT_ALLMEMBER,DELETE_MEMBER2,FIND_BY_ID,FIND_BY_TEAMID;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN: 
			query="SELECT MEM_ID userid, TEAM_ID, NAME, SSN,ROLL"+
					"  , PASSWORD FROM MEMBER WHERE MEM_ID LIKE '%s' and PASSWORD LIKE '%s'";
			break;
		case INSERT_MEMBAER:
			query="insert into member(mem_id,password,name,ssn,age,roll,team_id) values('%s','%s','%s','%s','%s','%s','%s') ";
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
			query="update member set PASSWORD='%s' where mem_id like '%s'"; 
			break;
		case UPDATE_MEMBER2:
			query="select mem_id,password from member where mem_id like '%s' and password like '%s'";
			break;
		case DELETE_MEMBER:
			query="delete from member where mem_id like '%s'";
			break;
		
		case SELECT_ALLMEMBER:
			query="select mem_id,SSN,name,password,roll,team_id,age from member";
			break;
		case FIND_BY_ID :
			query = "select mem_id,SSN,name,password,roll,team_id from member where mem_id like '%s'";
			break;
		case FIND_BY_TEAMID:
			query = "select mem_id,SSN,name,password,roll,team_id from member where team_id like '%s'";
			break;
		}
		return query;
	}
	

}
