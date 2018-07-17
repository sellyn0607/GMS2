package service;

import java.util.List;

import domain.*;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public SubjectBean findById(SubjectBean subject);
	public String update(SubjectBean subject);
	public String delete(SubjectBean subject);
	public List<SubjectBean> list();
}
