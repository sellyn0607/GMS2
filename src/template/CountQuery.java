package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class CountQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.COUNT.toString());
		
	}

	@Override
	void startPlay() {
		try {
			
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		
	}

	@Override
	void endPlay() {

		try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	}

