package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;

import pool.DBConstant;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	Connection conn;
	Statement stmt;
	private MemberDAOImpl() {}
	@Override
	public void insertMember(MemberBean member) {
		try {
			System.out.println(member);
			//(mem_id,password,name,ssn,age,roll,team_id,gender,subject)
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
		MemberBean bean =new MemberBean();
			try {
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(String.format(MemberQuery.FIND_BY_ID.toString(),member.getUserid()));
			
		while(rs.next()) {
			
			bean.setUserid(rs.getString("mem_id"));
			bean.setName(rs.getString("name"));
			bean.setSsn(rs.getString("SSN"));
			bean.setPassword(rs.getString("password"));
			bean.setRoll(rs.getString("roll"));
			bean.setTeamId(rs.getString("team_id"));
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return bean;
	}
	@Override
	public void updateMember(MemberBean member) {
		
		try {
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
					createStatement().executeQuery(String.format(MemberQuery.UPDATE_MEMBER2.toString(),
							member.getUserid(),member.getPassword().split("/")[0]));
			
		while(rs.next())
			{ 
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),
					member.getPassword().split("/")[1],member.getUserid()));
			}
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
	public List<MemberBean> findBySearch(String member) {
		List<MemberBean> lst=new ArrayList<>();
		
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERID, DBConstant.USERPW).getConnection().
			createStatement().executeQuery(String.format(MemberQuery.FIND_BY_TEAMID.toString(),member));
			
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setUserid(rs.getString("mem_id"));
				bean.setName(rs.getString("name"));
				bean.setSsn(rs.getString("SSN"));
				bean.setPassword(rs.getString("password"));
				bean.setRoll(rs.getString("roll"));
				bean.setTeamId(rs.getString("team_id"));
				lst.add(bean);
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}



}
