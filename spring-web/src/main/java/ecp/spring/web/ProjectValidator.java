package ecp.spring.web;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import ecp.spring.model.Project;
import ecp.spring.model.ProjectDTO;

import org.springframework.stereotype.Component;

@Component
public class ProjectValidator implements Validator {

    public boolean supports(Class clazz){
        return Project.class.equals(clazz);
    }

    public void validate(Object target, Errors errors){
        Project project = (Project)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.project.name");

        if(project.getStartDate().after(project.getEndDate())){
            errors.rejectValue("endDate", "error.project.endDate");
        }
    }
}
