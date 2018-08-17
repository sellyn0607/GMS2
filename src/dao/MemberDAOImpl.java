package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;

import pool.DBConstant;
import service.MemberServiceImpl;
import template.*;


public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	Connection conn;
	Statement stmt;
	private MemberDAOImpl() {}
	//private QueryTemplate q;
	@Override
	public void add(MemberBean member) {
		QueryTemplate q = new InsertQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid", member.getUserid());
		map.put("password",member.getPassword());
		map.put("name",member.getName());
		map.put("ssn",member.getSsn());
		map.put("age",member.getAge());
		map.put("gender",member.getGender());
		map.put("teamid",member.getTeamId());
		map.put("roll",member.getRoll());
		map.put("table","member");
		q.play(map);
	
	}
	@Override
	public MemberBean retrieve(MemberBean member) {
		QueryTemplate q = new RetrieveQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid",member.getUserid());
		map.put("table", "retrieve");
		q.play(map);
		
	
		return q.getMem2();
	}
	@Override
	public void modify(Map<?,?>param) {
		QueryTemplate q = new UpdateQuery();
		q.play(param);
		
		
		
	}
	@Override
	public void remove(MemberBean member) {
		QueryTemplate q = new DeleteQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid",member.getUserid());
		map.put("password",member.getPassword());
		q.play(map);
	}
	
	@Override
	public MemberBean login(MemberBean member) {
		QueryTemplate q = new LoginQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("userid",member.getUserid());
		map.put("password",member.getPassword());
		q.play(map);
	
		return q.getMem2();
	}
	@Override
	public int count() {
		QueryTemplate 	q = new CountQuery();
		HashMap<String,Object> map = new HashMap<>();
		q.play(map);
		return q.getCount();
	}

	
	public List<MemberBean> search(Map<?, ?> param) {
		QueryTemplate q = new SearchQuery();
		List<MemberBean> lst = new ArrayList<>();
		q.play(param);
		for(Object s: q.getList()) {
			lst.add((MemberBean)s);
		}
		
		return lst;
		
	}
	

}
