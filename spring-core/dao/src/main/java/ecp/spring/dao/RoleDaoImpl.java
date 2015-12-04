package ecp.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecp.spring.model.Role;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.transform.Transformers;
import org.hibernate.criterion.Order;
import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository("roleDaoImpl")
public class RoleDaoImpl implements RoleDao{

    @Autowired
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

	public List getRoles(int order, String column) {
        logger.info("Role Dao getRoles() method");
        if(order == 1){
            return sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc(column)).list();
        }else {
            return sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.desc(column)).list();
        }
    }
    public Role getRole(int roleId) {
        logger.info("Role Dao getRole() method");
        return (Role)sessionFactory.getCurrentSession().get(Role.class, roleId);
    }
    public void updateRole(Role role){
        logger.info("Role Dao updateRole() method");
    	sessionFactory.getCurrentSession().update(role);
    }
    public List listRolesWithPerson(){
        logger.info("Role Dao listRolesWithPerson() method");
        List list = sessionFactory.getCurrentSession().createQuery("select distinct proles.roleId as roleId, proles.roleType as roleType from Person person INNER JOIN person.roles as proles").setCacheable(true).setResultTransformer(Transformers.aliasToBean(Role.class)).list();
        return list;
    }
    public void addRole(Role role){
        logger.info("Role Dao addRole() method");
        sessionFactory.getCurrentSession().save(role);
    }
    public void deleteRole(int roleId){
        logger.info("Role Dao deleteRole() method");
        sessionFactory.getCurrentSession().delete(getRole(roleId));
    }
}