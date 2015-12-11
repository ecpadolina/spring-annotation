package ecp.spring.service;

import java.util.Set;
import java.util.Date;
import ecp.spring.model.ContactInfo;
import ecp.spring.model.Role;
import ecp.spring.model.Person;
import ecp.spring.model.Name;
import ecp.spring.model.Address;
import ecp.spring.model.PersonDTO;
import org.springframework.stereotype.Component;

@Component("personTransformer")
public class PersonTransformer{
	private Integer id;
	private Name name;
	private Address address;
	private Float gwa;
	private Date birthday;
	private String employmentStatus;
	private Set<ContactInfo> contacts;
	private Set<Role> roles;

	public PersonDTO toDTO(Person person){
		PersonDTO dto = new PersonDTO();
		id = person.getId();
		name = person.getName();
		address = person.getAddress();
		gwa = person.getGwa();
		birthday = person.getBirthday();
		employmentStatus = person.getEmploymentStatus();
		contacts = person.getContacts();
		roles = person.getRoles();

		if(id != null){
			dto.setId(id);
		}

		if(name != null){
			dto.setName(name);
		}

		if(address != null){
			dto.setAddress(address);
		}

		if(gwa != null){
			dto.setGwa(gwa);
		}

		if(birthday != null){
			dto.setBirthday(birthday);
		}

		if(employmentStatus != null){
			dto.setEmploymentStatus(employmentStatus);
		}

		if(contacts != null || !contacts.isEmpty()){
			dto.setContacts(contacts);
		}

		if(roles != null || !roles.isEmpty()){
			dto.setRoles(roles);
		}

		return dto;
	}

	public Person toPerson(PersonDTO dto){
		Person person = new Person();
		person.setName(dto.getName());
		person.setAddress(dto.getAddress());
		person.setGwa(dto.getGwa());
		person.setBirthday(dto.getBirthday());
		person.setEmploymentStatus(dto.getEmploymentStatus());
		person.setContacts(dto.getContacts());
		person.setRoles(dto.getRoles());
		return person;
	}
}