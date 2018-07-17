package dao;
import java.util.List;

import domain.*;

public interface ProjectDAO {
	//crud
	public void insertProject(ProjectBean project);
	public void score(ProjectBean project);
	public ProjectBean findById(ProjectBean  project);
	public String updateProject(ProjectBean  project);
	public String deleteProject(ProjectBean  project);
	public List<ProjectBean> list();
	
}
