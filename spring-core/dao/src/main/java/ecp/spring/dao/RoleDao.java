package ecp.spring.dao;

import ecp.spring.model.Role;
import java.util.List;

public interface RoleDao{
	List getRoles(int order, String column);
	Role getRole(int roleId);
	void updateRole(Role role);
	void addRole(Role role);
	void deleteRole(int roleId);
	List listRolesWithPerson();
}