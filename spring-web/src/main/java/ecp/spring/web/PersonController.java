package ecp.spring.web;

import ecp.spring.model.Person;
import ecp.spring.model.PersonDTO;
import ecp.spring.model.PersonModel;
import ecp.spring.model.Role;
import ecp.spring.model.ContactInfo;
import ecp.spring.service.PersonManagerImpl;
import ecp.spring.service.RoleManagerImpl;
import ecp.spring.service.PersonTransformer;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController{

	@Autowired
	PersonManagerImpl personManagerImpl;

	@Autowired
	RoleManagerImpl roleManagerImpl;

	@Autowired
	PersonValidator personValidator;

	@Autowired
	PersonFileParser personFileParser;

	@Autowired
	PersonTransformer personTransformer;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showIndex(ModelMap model){
		List personList = personManagerImpl.listPerson(0,1,"id");
		List roleList = roleManagerImpl.listRolesWithPerson();
		model.addAttribute("personList", personList);
		model.addAttribute("roleList", roleList);
		return "index";
	}

	@RequestMapping(value="/", headers="Accept=application/json")
	@ResponseBody
	public List personlist(@RequestParam("role") Integer role,
						   @RequestParam("order") Integer order,
						   @RequestParam("column") String column){
		return personManagerImpl.listPerson(role,order,column);
	}

	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	public @ResponseBody Person getPersonJSON(@PathVariable int id){
		return personManagerImpl.getPerson(id);
	}

	@RequestMapping(value="/person/add", method=RequestMethod.GET)
	public String addPersonGet(ModelMap model){
		Person person = new Person();
		model.addAttribute("person", person);
		addRolesToModel(model);
		return "personForm";
	}

	@RequestMapping(value="/person/add", method=RequestMethod.POST)
	public String addPersonPost(ModelMap model, @ModelAttribute(value="person") Person person, BindingResult result,
								 @RequestParam(value="contactInfo", required=false) String[] contactInfo,
								 @RequestParam(value="contactType", required=false) String[] contactType,
								 @RequestParam(value="personRoles", required=false) String[] personRoles){

		Set<ContactInfo> contacts = new HashSet<ContactInfo>();
		Set<Role> roles = new HashSet<Role>();
		if(contactInfo != null) {
			for (int i = 0; i < contactInfo.length; i++) {
				contacts.add(new ContactInfo(contactType[i], contactInfo[i]));
			}
			person.setContacts(contacts);
		}
		if(personRoles != null){
			for(int i = 0; i < personRoles.length; i++){
				roles.add(roleManagerImpl.getRole(Integer.parseInt(personRoles[i])));
			}
			person.setRoles(roles);
		}

		personValidator.validate(person,result);
		if(result.hasErrors()){
			model.addAttribute("contacts", contacts);
			addRolesToModel(model);
			return "personForm";
		}

		personManagerImpl.addPerson(person);
		return "redirect:/";

	}

	@RequestMapping(value="/person/edit/{id}", method=RequestMethod.GET)
	public String editPersonGet(ModelMap model, @PathVariable int id){
		PersonDTO person = personTransformer.toDTO(personManagerImpl.getPerson(id));
		model.addAttribute("person", person);
		model.addAttribute("contacts", person.getContacts());
		addRolesToModel(model);
		return "personForm";
	}

	@RequestMapping(value="/person/edit/{id}", method=RequestMethod.POST)
	public String editPersonPost(ModelMap model, @ModelAttribute(value="person") Person person, BindingResult result,
								 @RequestParam(value="contactInfo", required=false) String[] contactInfo,
								 @RequestParam(value="contactType", required=false) String[] contactType,
								 @RequestParam(value="personRoles", required=false) String[] personRoles){
		Set<ContactInfo> contacts = new HashSet<ContactInfo>();
		Set<Role> roles = new HashSet<Role>();
		if(contactInfo != null) {
			for (int i = 0; i < contactInfo.length; i++) {
				contacts.add(new ContactInfo(contactType[i], contactInfo[i]));
			}
			person.setContacts(contacts);
		}
		if(personRoles != null){
			for(int i = 0; i < personRoles.length; i++){
				roles.add(roleManagerImpl.getRole(Integer.parseInt(personRoles[i])));
			}
			person.setRoles(roles);
		}

		personValidator.validate(person,result);
		if(result.hasErrors()){
			model.addAttribute("contacts", contacts);
			addRolesToModel(model);
			return "personForm";
		}
		personManagerImpl.updatePerson(person);
		return "redirect:/";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String deletePerson(@RequestParam(value="id") int id){
		Person person = personManagerImpl.getPerson(id);
		personManagerImpl.deletePerson(person);
		return "redirect:/";
	}

	@RequestMapping(value="/person/upload", method=RequestMethod.GET)
	public String uploadFileGet(){
		return "upload";
	}

	@RequestMapping(value="/person/upload", method=RequestMethod.POST)
	public String uploadFilePost(ModelMap model, @RequestParam(value="file") MultipartFile file){
		PersonDTO person = new PersonDTO();
		if(file != null){
			person = personFileParser.extractPersonFromFile(file);
			/*model.addAttribute("person", person);
			model.addAttribute("contacts", person.getContacts());
			addRolesToModel(model);
			return "personForm";*/
		}
		personManagerImpl.addPerson(personTransformer.toPerson(person));
		return "redirect:/";
	}

	public void addRolesToModel(ModelMap model){
		model.addAttribute("roles", roleManagerImpl.getRoles(1, "roleId"));
	}

}