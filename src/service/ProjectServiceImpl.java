package service;

import java.util.ArrayList;
import java.util.List;


import domain.ProjectBean;

public class ProjectServiceImpl implements ProjectService{
	private static ProjectService instance = new ProjectServiceImpl();
	public static ProjectService getInstance() {return instance;}
	private ProjectServiceImpl() {}	
	@Override
	
	public void createMember(ProjectBean project) {
		
		
		
	}

	@Override
	public void score(ProjectBean project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectBean findById(ProjectBean project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(ProjectBean project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(ProjectBean project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
