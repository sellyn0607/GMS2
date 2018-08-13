package enums;

import template.ColumnFinder;

public enum MemberQuery {
	LOGIN,INSERT,COUNT,UPDATE,UPDATE2,DELETE,
	search,DELETE2,RETRIEVE,SEARCH,All_LIST,COUNT2;
	
	
	@Override
	public String toString() {
		String query = "";
		
		switch (this) {
		case LOGIN: 
			query=	"  SELECT  "+ ColumnFinder.find(Domain.MEMBER)
			+" FROM MEMBER WHERE userid LIKE ? and PASSWORD LIKE ?";
			break;
		case INSERT:
			query="insert into member(userid,password,name,ssn,age,roll,teamid,gender) values(?, ?, ?, ?, ?, ?, ?, ?) ";
			break;
	
		case COUNT:
			query="select count(*) AS count FROM MEMBER";
			
			break;
		case COUNT2:
			query="select count(*) AS count FROM MEMBER where %s like ? ";
			break;
		case UPDATE:
			query="update member set PASSWORD=? ,roll= ?,teamid= ? where userid like ?";
			//query = "update member set %s = ? where userid like ?";
			break;
		case UPDATE2:
			query="select userid,password from member where userid like ? and password like ?";
			break;
		case DELETE:
			query="delete from member where userid like ? and password like ? ";
			break;
		
		case SEARCH:
			query="select t.* from (select rownum seq,m.* from member m WHERE %s like ? order by seq desc) t where t.seq between ? and ?";
			break;//얘가 search
		case RETRIEVE :
			query = "select userid,SSN,name,password,roll,teamid,age,gender from member where userid like ?";
			break;
			
		case All_LIST:
			query = "select t.* from (select rownum seq,m.* from member m order by seq desc) t where t.seq between ? and ?" ;
		default:
			break;
		}
		return query;
	}
	

}
