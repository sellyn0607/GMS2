package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class RetrieveQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.RETRIEVE.toString());
		
	}

	@Override
	void startPlay() {
		try {
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, map.get("userid").toString());
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		
	}

	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem2.setUserid(rs.getString("userid"));
				mem2.setAge(rs.getString("age"));
				mem2.setGender(rs.getString("gender"));
				mem2.setName(rs.getString("name"));
				mem2.setPassword(rs.getString("password"));
				mem2.setRoll(rs.getString("roll"));
				mem2.setSsn(rs.getString("ssn"));
				mem2.setTeamId(rs.getString("teamid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
	}

