package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class DeleteQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.DELETE.toString());
		
	}

	@Override
	void startPlay() {
		try {
			System.out.println(map.get("userid"));
			System.out.println(map.get("password"));
			System.out.println(map.get("sql"));
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, (String)map.get("userid"));
			pstmt.setString(2, (String)map.get("password"));
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

