package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;

import pool.DBConstant;
import service.MemberServiceImpl;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	Connection conn;
	Statement stmt;
	private MemberDAOImpl() {}
	@Override
	public void insertMember(MemberBean member) {
		try {
			
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeUpdate(String.format(MemberQuery.INSERT_MEMBAER.toString(),member.getUserid(),
					member.getPassword(),member.getName(),member.getSsn(),member.getAge(),
					member.getRoll(),member.getTeamId(),member.getGender()));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean mem =new MemberBean();
			try {
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(String.format(MemberQuery.FIND_BY_ID.toString(),member.getUserid() ));
			
		if(rs.next()) {
			
			mem.setUserid(rs.getString("mem_id"));
			System.out.println(mem.getUserid());
			mem.setName(rs.getString("name"));
			mem.setSsn(rs.getString("SSN"));
			mem.setPassword(rs.getString("password"));
			mem.setRoll(rs.getString("roll"));
			mem.setTeamId(rs.getString("team_id"));
			mem.setAge(rs.getString("age"));
			mem.setGender(rs.getString("gender"));
			
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return mem;
	}
	@Override
	public void updateMember(MemberBean member) {
		
		try {
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
					createStatement().executeQuery(String.format(MemberQuery.UPDATE_MEMBER.toString(),
							member.getPassword(),member.getRoll(),member.getTeamId(),member.getUserid()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void deleteMember(MemberBean member) {
		try {
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
					createStatement().executeQuery(String.format(MemberQuery.UPDATE_MEMBER2.toString(),
							member.getUserid(),member.getPassword()));
			
			while(rs.next()) {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),member.getUserid()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	@Override
	public List<MemberBean>  selectAllMember() {
		List<MemberBean> lst=new ArrayList<>();

		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(MemberQuery.SELECT_ALLMEMBER.toString());
			
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setUserid(rs.getString("mem_id"));
				bean.setName(rs.getString("name"));
				bean.setSsn(rs.getString("SSN"));
				bean.setPassword(rs.getString("password"));
				bean.setRoll(rs.getString("roll"));
				bean.setTeamId(rs.getString("team_id"));
				bean.setAge(rs.getString("age"));
				bean.setGender(rs.getString("gender"));
				lst.add(bean);
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		try {
			
			ResultSet rs =DatabaseFactory.createDatabase(
					Vendor.ORACLE,DBConstant.USERID, DBConstant.USERPW).getConnection().
					createStatement().
					executeQuery(String.format(MemberQuery.LOGIN.toString(),member.getUserid(),member.getPassword()));
			
			while(rs.next()) {
				m=new MemberBean();
				m.setUserid(rs.getString("userid"));
				m.setName(rs.getString("NAME"));
				m.setSsn(rs.getString("SSN"));
				m.setPassword(rs.getString("PASSWORD"));
			}
			if(m==null) {
				m=new MemberBean();
				m.setSsn("999");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return m;
	}
	@Override
	public int countMember() {
		int count = 0;
		try {
			
			 ResultSet rs =DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(MemberQuery.COUNT_MEMBER.toString());
			 
			 while(rs.next()) {
				 count=rs.getInt("count");
			 }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<MemberBean> Search(String member) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String,Object> map = new HashMap<>();
		map.put("column",member.split("/")[0]);
		map.put("value",member.split("/")[1]);
		map.put("table",Domain.ADMIN);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		
		return list;
/*		List<MemberBean> lst=new ArrayList<>();
		String option = member.split("/")[0];
		String text = member.split("/")[1];
		String sql= "select mem_id,SSN,name,password,roll,team_id,age,gender from member " 
				+ " where "+option+ " like "+"'"+text+"'";
		
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(sql);
			
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setUserid(rs.getString("mem_id"));
				bean.setName(rs.getString("name"));
				bean.setSsn(rs.getString("SSN"));
				bean.setPassword(rs.getString("password"));
				bean.setRoll(rs.getString("roll"));
				bean.setTeamId(rs.getString("team_id"));
				bean.setGender(rs.getString("gender"));
				bean.setAge(rs.getString("age"));
				
				lst.add(bean);
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;*/
	}
	@Override
	public List<MemberBean> findByName(String member) {
		List<MemberBean> lst=new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
					createStatement().executeQuery(String.format(MemberQuery.FIND_BY_NAME.toString(),member));
			
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setUserid(rs.getString("mem_id"));
				bean.setName(rs.getString("name"));
				bean.setSsn(rs.getString("SSN"));
				bean.setPassword(rs.getString("password"));
				bean.setRoll(rs.getString("roll"));
				bean.setTeamId(rs.getString("team_id"));
				bean.setGender(rs.getString("gender"));
				bean.setAge(rs.getString("age"));
				lst.add(bean);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}



}
