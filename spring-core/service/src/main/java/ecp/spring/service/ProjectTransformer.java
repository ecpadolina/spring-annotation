package ecp.spring.service;

import java.util.Set;
import java.util.List;
import ecp.spring.model.Project;
import ecp.spring.model.ProjectDTO;
import org.springframework.stereotype.Component;

@Component("projectTransformer")
public class ProjectTransformer {

    public ProjectDTO toDTO(Project project){
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setPersons(project.getPersons());
        return dto;
    }

    public Project toProject(ProjectDTO dto){
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setPersons(dto.getPersons());
        return project;
    }
}
