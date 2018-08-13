package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class LoginQuery  extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.LOGIN.toString());
		
	}

	@Override
	void startPlay() {
		try {
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1,(String)map.get("userid"));
			pstmt.setString(2,(String)map.get("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	void endPlay() {
			try {
					ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					System.out.println("됨?");
					mem2.setUserid(rs.getString("userid"));
					mem2.setAge(rs.getString("age"));
					mem2.setGender(rs.getString("gender"));
					mem2.setName(rs.getString("name"));
					mem2.setPassword(rs.getString("password"));
					mem2.setRoll(rs.getString("roll"));
					mem2.setSsn(rs.getString("ssn"));
					mem2.setTeamId(rs.getString("teamid"));
				}else {
				
					mem2.setSsn("999");
					System.out.println(mem2.getSsn());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
	}
	}

