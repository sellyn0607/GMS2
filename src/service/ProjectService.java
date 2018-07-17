package service;
import java.util.List;

import domain.*;

public interface ProjectService {
	//crud
	public void createMember(ProjectBean project);
	public void score(ProjectBean project);
	public ProjectBean findById(ProjectBean  project);
	public String update(ProjectBean  project);
	public String delete(ProjectBean  project);
	public List<ProjectBean> list();
	
}
