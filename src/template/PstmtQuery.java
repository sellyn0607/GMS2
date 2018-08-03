package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.*;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(
				"SELECT "+ ColumnFinder.find(Domain.MEMBER)
				+" FROM %s WHERE %s LIKE ? ", map.get("table"),map.get("column")));
		
		
	}

	@Override
	void startPlay() {
		String aa = "%"+map.get("value").toString()+"%";
		System.out.println(aa);
		try {
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, "%"+map.get("value").toString()+"%");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
