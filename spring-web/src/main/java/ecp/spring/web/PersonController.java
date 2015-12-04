package ecp.spring.web;

import ecp.spring.model.Person;
import ecp.spring.model.PersonModel;
import ecp.spring.model.Role;
import ecp.spring.service.PersonManagerImpl;
import ecp.spring.service.RoleManagerImpl;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PersonController{

	@Autowired
	PersonManagerImpl personManagerImpl;

	@Autowired
	RoleManagerImpl roleManagerImpl;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showIndex(ModelMap model){
		List<PersonModel> personList = personManagerImpl.listPerson(0,1,"id");
		List<Role> roleList = roleManagerImpl.listRolesWithPerson();
		model.addAttribute("personList", personList);
		model.addAttribute("roleList", roleList);
		return "index";
	}

	@RequestMapping(value="/", headers="Accept=application/json")
	@ResponseBody
	public List<PersonModel> personlist(@RequestParam("role") Integer role,
									   @RequestParam("order") Integer order,
									   @RequestParam("column") String column){
		return personManagerImpl.listPerson(role,order,column);
	}

	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	public @ResponseBody Person getPersonJSON(@PathVariable int id){
		return personManagerImpl.getPerson(id);
	}

	@RequestMapping(value="/person/edit/{id}", method=RequestMethod.GET)
	public String editPersonGet(ModelMap model, @PathVariable int id){
		Person person = personManagerImpl.getPerson(id);
		model.addAttribute("person", person);
		model.addAttribute("contacts", person.getContacts());
		model.addAttribute("roles", roleManagerImpl.getRoles(1, "roleId"));
		return "personForm";
	}
}