package ecp.spring.service;

import ecp.spring.model.Person;
import java.util.List;

public interface PersonManager{
	void addPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person person);
	Person getPerson(int id);
	List listPerson(int roleId, int order, String column);
	//List listPersonWithRoles(int roleId);
}