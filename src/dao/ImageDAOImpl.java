package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;
import template.*;


public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	@Override
	public void insert(Map<?,?>param) {
		QueryTemplate q = new InsertQuery();
		q.play(param);
	}
	@Override
	public ImageBean call(String img) {
		QueryTemplate q = new RetrieveQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid",img);
		map.put("table","imgCall");
		q.play(map);
		return q.getImg2();
	}

}
