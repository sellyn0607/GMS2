package dao;

import java.util.List;

import domain.*;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public SubjectBean findById(SubjectBean subject);
	public String updateSubject(SubjectBean subject);
	public String deleteSubject(SubjectBean subject);
	public List<SubjectBean> selectSubjectSearch(String name);
	public List<SubjectBean> list();
}
