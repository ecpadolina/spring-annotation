package ecp.spring.web;

import ecp.spring.model.Role;
import ecp.spring.service.RoleManagerImpl;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController{

	@Autowired
	RoleManagerImpl roleManagerImpl;

	@RequestMapping("/role")
	public String roleIndex(Model model){
		model.addAttribute("roleList",roleManagerImpl.getRoles(1,"roleId"));
		return "roleIndex";
	}

	@RequestMapping(value="/role", headers="Accept=application/json")
	@ResponseBody
	public List roleListSort(@RequestParam("order") Integer order,
								   @RequestParam("column") String column){
		return roleManagerImpl.getRoles(order, column);
	}

	@RequestMapping(value="/role/add", method=RequestMethod.GET)
	public String addRoleGet(ModelMap model){
		Role role = new Role();
		model.addAttribute("role", role);
		return "roleForm";
	}

	@RequestMapping(value="role/add", method=RequestMethod.POST)
	public String addRolePost(@ModelAttribute(value="role") Role role){
		roleManagerImpl.addRole(role);
		return "redirect:/role";
	}

	@RequestMapping(value="/role", method=RequestMethod.POST)
	public String deleteRole(@RequestParam(value="roleId") Integer roleId){
		roleManagerImpl.deleteRole((roleId));
		return "redirect:/role";
	}

	@RequestMapping(value="/role/edit/{id}", method=RequestMethod.GET)
	public String editRoleGet(Model model, @PathVariable int id){
		model.addAttribute("role", roleManagerImpl.getRole(id));
		return "roleForm";
	}

	@RequestMapping(value="/role/edit/{id}", method=RequestMethod.POST)
	public String editRolePost(Model model, @ModelAttribute(value="role") Role role){
		roleManagerImpl.updateRole(role);
		return "redirect:/role";
	}
}