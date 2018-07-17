package service;

import java.util.List;

import domain.*;

public interface ExamService {
	public void createExam(ExamBean exam);
	public ExamBean findById(ExamBean exam);
	public String update(ExamBean exam);
	public String delete(ExamBean exam);
	public List<ExamBean> list();
	public void score(MemberBean exam);
	// list 한개더 ? count ?? 
	
}
