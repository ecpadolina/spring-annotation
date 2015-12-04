package ecp.spring.dao;

import ecp.spring.model.Person;
import java.util.List;

public interface PersonDao{
	void addPerson(Person person);
	Person getPerson(int personID);
	void updatePerson(Person updatedPerson);
	void deletePerson(Person person);
	//List listPerson(int order, String column);
	List listPerson(int roleId, int order, String column);
}