package ecp.spring.service;

import java.util.List;
import ecp.spring.model.Project;
import ecp.spring.model.ProjectDTO;
import ecp.spring.dao.ProjectDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("projectManagerImpl")
@Transactional(rollbackFor=Exception.class)
public class ProjectManagerImpl implements ProjectManager{

    @Autowired
  	private ProjectDaoImpl projectDao;

	@Autowired
	private ProjectTransformer projectTransformer;

    @Transactional(readOnly=true)
  	public List listProjects(){
  		return projectDao.listProjects();
  	}

    @Transactional(readOnly=true)
  	public Project getProject(int id){
  		return (projectDao.getProject(id));
  	}

  	public void addProject(ProjectDTO project){
  		projectDao.addProject(projectTransformer.toProject(project));
  	}

  	public void deleteProject(int id){
  		projectDao.deleteProject(id);
  	}

  	public void updateProject(Project project){
  		projectDao.updateProject(project);
  	}
}