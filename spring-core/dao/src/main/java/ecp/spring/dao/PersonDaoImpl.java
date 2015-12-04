package ecp.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecp.spring.model.Person;
import ecp.spring.model.PersonModel;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository("personDaoImpl")
public class PersonDaoImpl implements PersonDao{
	
    @Autowired
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

	public void addPerson(Person person) {
        logger.info("Person Dao addPerson() method");
        sessionFactory.getCurrentSession().save(person);
    }

    public Person getPerson(int personID) {
        logger.info("Person Dao getPerson() method");
        return (Person)sessionFactory.getCurrentSession().get(Person.class, personID);
    }

    public void updatePerson(Person updatedPerson) {
        logger.info("Person Dao updatePerson() method");
        sessionFactory.getCurrentSession().update(updatedPerson);
    }

    public void deletePerson(Person person) {
        logger.info("Person Dao deletePerson() method");
        sessionFactory.getCurrentSession().delete(person);
    }
    
    public List listPerson(int roleId, int order, String column){
        logger.info("Person Dao listPerson() method");
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Person.class);
        ProjectionList properties = Projections.projectionList();
        if(roleId != 0){
            crit.add(Restrictions.eq("roles.roleId", roleId));
            crit.createAlias("roles","roles");
        }
        if(order == 1){
            crit.addOrder(Order.asc(column));
        } else if(order == 2){
            crit.addOrder(Order.desc(column));
        }

        //crit.createAlias("contacts","contacts", JoinType.FULL_JOIN);
        properties.add(Projections.distinct(Projections.property("id")), "id");
        properties.add(Projections.property("name.firstName"), "firstName");
        properties.add(Projections.property("name.lastName"), "lastName");
        properties.add(Projections.property("birthday"), "birthday");
        properties.add(Projections.property("gwa"), "gwa");
        //properties.add(Projections.property("contacts.contactInfo"), "contactInfo");
        crit.setProjection(properties);
        crit.setResultTransformer(Transformers.aliasToBean(PersonModel.class));
        return crit.list();
    }
}