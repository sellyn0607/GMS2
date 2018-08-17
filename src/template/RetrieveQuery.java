package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.ImgQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;


public class RetrieveQuery  extends QueryTemplate{

	@Override
	void initialize() {
		
		switch((String)map.get("table")) {
		
		case "retrieve":
			map.put("sql",MemberQuery.RETRIEVE.toString());
		break;
		
		case "imgCall":
			map.put("sql",ImgQuery.CALLIMG.toString());
		break;
		}
	}

	@Override
	void startPlay() {
		try {
			switch((String)map.get("table")) {
			case"retrieve" :case "imgCall": 
			pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, map.get("userid").toString());
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
			ResultSet rs= pstmt.executeQuery();
			
			switch((String)map.get("table")) {
			case "retrieve":
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
			break;
			case "imgCall":
				while(rs.next()) {
				img2.setImgName(rs.getString("img_name"));
				img2.setExtension(rs.getString("extension"));
				}
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
	}

