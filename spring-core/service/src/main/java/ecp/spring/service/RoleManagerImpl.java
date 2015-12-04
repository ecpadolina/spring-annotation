package ecp.spring.service;

import ecp.spring.dao.RoleDaoImpl;
import ecp.spring.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("roleManagerImpl")
@Transactional(rollbackFor=Exception.class)
public class RoleManagerImpl implements RoleManager{

  @Autowired
  private RoleDaoImpl roleDaoImpl;
  private final Logger logger = LoggerFactory.getLogger(RoleManagerImpl.class);
  
  @Transactional(readOnly=true)
  public List getRoles(int order, String column){
    logger.info("Role Service getRoles() method");
    return roleDaoImpl.getRoles(order, column);
  }

  @Transactional(readOnly=true)
  public Role getRole(int roleId){
    logger.info("Role Service getRole() method");
    return roleDaoImpl.getRole(roleId);
  }

  public void updateRole(Role role){
    logger.info("Role Service updateRole() method");
    roleDaoImpl.updateRole(role);
  }

  @Transactional(readOnly=true)
  public List listRolesWithPerson(){
    logger.info("Role Service listRolesWithPerson() method");
    return roleDaoImpl.listRolesWithPerson();
  }

  public void addRole(Role role){
    logger.info("Role Service addRoles() method");
    roleDaoImpl.addRole(role);
  }

  public void deleteRole(int roleId){
    logger.info("Role Service deleteRoles() method");
    roleDaoImpl.deleteRole(roleId);
  }
  
}