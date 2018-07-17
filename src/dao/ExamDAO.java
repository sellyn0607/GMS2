package dao;

import java.util.List;

import domain.*;

public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public ExamBean findById(ExamBean exam);
	public String updateExam(ExamBean exam);
	public String deleteExam(ExamBean exam);
	public List<ExamBean> list();
	public void score(MemberBean exam);
}
