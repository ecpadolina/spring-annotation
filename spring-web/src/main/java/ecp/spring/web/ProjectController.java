package ecp.spring.web;

import ecp.spring.model.Project;
import ecp.spring.model.Person;
import ecp.spring.model.ProjectDTO;
import ecp.spring.service.PersonManagerImpl;
import ecp.spring.service.ProjectManagerImpl;
import ecp.spring.service.ProjectTransformer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ProjectController {

    @Autowired
    private ProjectManagerImpl projectManagerImpl;

    @Autowired
    private PersonManagerImpl personManagerImpl;

    @Autowired
    private ProjectValidator projectValidator;

    @Autowired
    private ProjectTransformer projectTransformer;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/project")
    public String projectIndex(Model model) {
        model.addAttribute("projectList", projectManagerImpl.listProjects());
        return "projectIndex";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.GET)
    public String addProjectGet(ModelMap model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("persons", personManagerImpl.listPerson(0, 1, "id"));
        return "projectForm";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProjectPost(ModelMap model, @ModelAttribute(value = "project") ProjectDTO project, BindingResult result,
                                 @RequestParam(value = "members", required = false) String[] personIds) {
        projectValidator.validate(project, result);
        if (result.hasErrors()) {
            model.addAttribute("persons", personManagerImpl.listPerson(0, 1, "id"));
            return "projectForm";
        }

        Set<Person> members = new HashSet<Person>();
        if (personIds != null) {
            for (String id : personIds) {
                members.add(personManagerImpl.getPerson(Integer.parseInt(id)));
            }
            project.setPersons(members);
        }

        projectManagerImpl.addProject(project);
        return "redirect:/project";
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public String deleteProject(@RequestParam(value = "projectId") int id) {
        projectManagerImpl.deleteProject(id);
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/edit/{id}", method = RequestMethod.GET)
    public String editProjectGet(ModelMap model, @PathVariable(value = "id") int id) {
        ProjectDTO project = projectTransformer.toDTO(projectManagerImpl.getProject(id));
        model.addAttribute("persons", personManagerImpl.listPerson(0, 1, "id"));
        model.addAttribute("project", project);
        return "projectForm";
    }

    @RequestMapping(value = "/project/edit/{id}", method = RequestMethod.POST)
    public String editProjectPost(ModelMap model, @ModelAttribute(value = "project") Project project,
                                  BindingResult result,
                                  @RequestParam(value = "members", required = false) String[] personIds) {
        projectValidator.validate(project, result);
        if (result.hasErrors()) {
            model.addAttribute("persons", personManagerImpl.listPerson(0, 1, "id"));
            return "projectForm";
        }

        Set<Person> members = new HashSet<Person>();
        if (personIds != null) {
            for (String id : personIds) {
                members.add(personManagerImpl.getPerson(Integer.parseInt(id)));
            }
            project.setPersons(members);
        }
        System.out.println(project.getId());
        projectManagerImpl.updateProject(project);
        return "redirect:/project";
    }
}