package ecp.spring.service;

import ecp.spring.model.Role;
import java.util.List;

public interface RoleManager{
	List getRoles(int order, String column);
	Role getRole(int roleId);
	void updateRole(Role role);
	List listRolesWithPerson();
	void addRole(Role role);
	void deleteRole(int id);
}