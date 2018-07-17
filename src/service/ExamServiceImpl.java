package service;

import java.util.ArrayList;
import java.util.List;

import dao.ExamDAOImpl;
import dao.RecordDAOImpl;
import dao.SubjectDAOImpl;
import domain.*;


public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}

	
	
	@Override
	public void createExam(ExamBean exam) {
		
		String[] arr = exam.getScore().split("/");
		exam.getExamSeq();
		System.out.println("서비스임플 :"+exam);
		RecordBean record = new RecordBean();
		record.setGrade("");
		record.setAvg("");
		RecordDAOImpl.getInstance().insertRecord(record);
		System.out.println("java : "+arr[0]+"   HTML5 : "+arr[1]+"   R :"+arr[2]+"   SQL :"+ arr[3]+"   Phython : "+arr[4]);
		exam.setScore(exam.getScore().split("/")[0]);
		exam.setSubSeq(SubjectDAOImpl.getInstance().selectSubjectSearch("JAVA").get(0).getSubSeq());
		
		
		exam.setRecoreSeq(RecordDAOImpl.getInstance().selectFirstRowNum());
		ExamDAOImpl.getInstance().insertExam(exam);
		
		
	}

	@Override
	public ExamBean findById(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(ExamBean exam) {
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
		
	}

}
