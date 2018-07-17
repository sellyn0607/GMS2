package dao;

import java.util.ArrayList;
import java.util.List;

import domain.*;


public class ExamDAOImpl implements ExamDAO{
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getInstance() {return instance;}
	private ExamDAOImpl() {}
	@Override
	public void insertExam(ExamBean exam) {
		
		
	}
	@Override
	public ExamBean findById(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void score(MemberBean exam) {
		// TODO Auto-generated method stub
		
	}


	
	

}
