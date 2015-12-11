package ecp.spring.service;

import ecp.spring.dao.PersonDaoImpl;
import ecp.spring.model.Person;
import ecp.spring.model.PersonDTO;
import ecp.spring.service.PersonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personManagerImpl")
@Transactional(rollbackFor=Exception.class)
public class PersonManagerImpl implements PersonManager{

  @Autowired
  private PersonDaoImpl personDaoImpl;

  @Autowired
  private PersonTransformer personTransformer;

  private final Logger logger = LoggerFactory.getLogger(PersonManagerImpl.class);
  
  public void addPerson(Person person){
    logger.info("Person Service addPerson() method");
    personDaoImpl.addPerson(person);
  }
  
  public void updatePerson(Person person){
    logger.info("Person Service updatePerson() method");
    personDaoImpl.updatePerson(person);
  }
  
  public void deletePerson(Person person){
    logger.info("Person Service deletePerson() method");
    personDaoImpl.deletePerson(person);
  }
  
  @Transactional(readOnly=true)
  public Person getPerson(int id){
    logger.info("Person Service getPerson() method");
    return (Person)personDaoImpl.getPerson(id);
  }
  
  @Transactional(readOnly=true)
  public List listPerson(int roleId, int order, String column){
    logger.info("Person Service listPerson() method");
    return personDaoImpl.listPerson(roleId, order,column);
  }

  /*public List listPersonWithRoles(int roleId){
    return personDaoImpl.listPersonWithRoles(roleId);
  }*/
  
}