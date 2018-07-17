package dao;

import java.util.*;



import domain.ProjectBean;

public class ProjectDAOImpl implements ProjectDAO{
	private static ProjectDAO instance = new ProjectDAOImpl();
	public static ProjectDAO getInstance() {return instance;}
	private ProjectDAOImpl() {}
	@Override
	public void insertProject(ProjectBean project) {
		// TODO Auto-generated method stub
		
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
	public String updateProject(ProjectBean project) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteProject(ProjectBean project) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectBean> list() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	

	
}
