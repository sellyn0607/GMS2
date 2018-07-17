package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {}
	
	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubjectBean findById(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
