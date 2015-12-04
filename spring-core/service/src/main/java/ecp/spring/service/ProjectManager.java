package ecp.spring.service;

import java.util.List;
import ecp.spring.model.Project;

public interface ProjectManager {
	
	public List listProjects();

	public Project getProject(int id);
	
	public void addProject(Project project);

	public void deleteProject(int id);

	public void updateProject(Project project);

}
