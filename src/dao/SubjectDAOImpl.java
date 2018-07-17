package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{
	private static SubjectDAO instance = new SubjectDAOImpl();
	public static SubjectDAO getInstance() {return instance;}
	private SubjectDAOImpl() {}
	@Override
	public void insertSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SubjectBean findById(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> selectSubjectSearch(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
