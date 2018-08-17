package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.ImgQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class InsertQuery  extends QueryTemplate{

	@Override
	void initialize() {
		switch((String)map.get("table")) {
		case "member":
			map.put("sql",MemberQuery.INSERT.toString());
		break;
		case "img":
			map.put("sql",ImgQuery.INSERT.toString());
		break;
		}
	}

	@Override
	void startPlay() {
		try {
			switch((String)map.get("table")) {
			case "member":
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1,(String)map.get("userid"));
			pstmt.setString(2,(String)map.get("password"));
			pstmt.setString(3,(String)map.get("name"));
			pstmt.setString(4,(String)map.get("ssn"));
			pstmt.setString(5,(String)map.get("age"));
			pstmt.setString(6,(String)map.get("roll"));
			pstmt.setString(7,(String)map.get("teamid"));
			pstmt.setString(8,(String)map.get("gender"));
			break;
			case "img" :
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1,(String)map.get("imgname"));
			pstmt.setString(2,(String)map.get("ext"));
			pstmt.setString(3,(String)map.get("userid"));
			break;
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		
	}

	@Override
	void endPlay() {

	
			try {
				
			switch((String)map.get("table")) {
			case "member":
				pstmt.executeQuery();
				break;
			case "img" :
				pstmt.executeQuery();
				break;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	}

