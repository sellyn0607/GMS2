package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class SearchQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",!map.containsKey("column")? 
				MemberQuery.All_LIST.toString() : 
			String.format(MemberQuery.SEARCH.toString(),map.get("column")));
		
	}

	@Override
	void startPlay() {
		try {
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			
			int j=0;
			if(map.containsKey("column")) {
				j++;
				pstmt.setString(j,"%"+ map.get("value")+ "%");
			}
			j++;
			pstmt.setString(j, (String)map.get("beginRow"));
			j++;
			pstmt.setString(j, (String)map.get("endRow"));
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
			MemberBean mem = null;
			while(rs.next()) {
				mem=new MemberBean();
				mem.setUserid(rs.getString("userid"));
				mem.setAge(rs.getString("age"));
				mem.setGender(rs.getString("gender"));
				mem.setName(rs.getString("name"));
				mem.setPassword(rs.getString("password"));
				mem.setRoll(rs.getString("roll"));
				mem.setSsn(rs.getString("ssn"));
				mem.setTeamId(rs.getString("teamid"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
	}

