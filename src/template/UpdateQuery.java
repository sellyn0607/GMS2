package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class UpdateQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.UPDATE.toString());
		
	}

	@Override
	void startPlay() {
		try {
			//PASSWORD=? ,roll= ?,teamid= ? where userid like ?";
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, (String)map.get("password"));
			pstmt.setString(2, (String)map.get("roll"));
			pstmt.setString(3, (String)map.get("teamid"));
			pstmt.setString(4, (String)map.get("userid"));
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		
	}

	@Override
	void endPlay() {

		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	}

