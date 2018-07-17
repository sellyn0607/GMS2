package service;

import java.util.List;

import domain.RecordBean;

public class RecordServiceImpl implements RecordService{
	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {return instance;}
	private RecordServiceImpl() {}	

	@Override
	public void createRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecordBean findById(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
