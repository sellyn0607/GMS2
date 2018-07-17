package dao;

import java.util.List;

import domain.RecordBean;

public class RecordDAOImpl implements RecordDAO{
	private static RecordDAO instance = new RecordDAOImpl();
	public static RecordDAO getInstance() {return instance;}
	private RecordDAOImpl() {}
	@Override
	public void insertRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RecordBean findById(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectFirstRowNum() {
		// TODO Auto-generated method stub
		return null;
	}	



}
