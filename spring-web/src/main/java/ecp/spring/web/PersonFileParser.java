package ecp.spring.web;

import ecp.spring.model.Person;
import ecp.spring.model.PersonDTO;
import ecp.spring.model.Role;
import ecp.spring.model.ContactInfo;
import ecp.spring.model.Name;
import ecp.spring.model.Address;
import ecp.spring.service.RoleManagerImpl;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("personFileParser")
public class PersonFileParser{

	@Autowired
	RoleManagerImpl roleManagerImpl;

	public PersonDTO extractPersonFromFile(MultipartFile file){
		String[] arrayLines = null;
		
		try {
			arrayLines = IOUtils.toString(file.getInputStream(), "UTF-8").split("\n");
		} catch(Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		PersonDTO person = new PersonDTO();
		Name name = new Name();
		Address address = new Address();
		Set<ContactInfo> contacts = new HashSet<ContactInfo>();
		Set<Role> roles =  new HashSet<Role>();

		for(String lines : arrayLines){
			String[] line = lines.split("=");

			if(line[0].equals("First Name")){
				name.setFirstName(line[1]);
			} else if(line[0].equals("Middle Name")){
				name.setMiddleName(line[1]);
			} else if(line[0].equals("Last Name")){
				name.setLastName(line[1]);
			} else if(line[0].equals("House Number")){
				address.setHouseNo(line[1]);
			} else if(line[0].equals("Street")){
				address.setStreet(line[1]);
			} else if(line[0].equals("Barangay")){
				address.setBarangay(line[1]);
			} else if(line[0].equals("Subdivision")){
				address.setSubdivision(line[1]);
			} else if(line[0].equals("Municipality")){
				address.setMunicipality(line[1]);
			} else if(line[0].equals("Province")){
				address.setProvince(line[1]);
			} else if(line[0].equals("Zipcode")){
				try{
					address.setZipcode(Integer.parseInt(line[1]));
				} catch (Exception e){
					address.setZipcode(0);
				}
			} else if(line[0].equals("Birthday")){
				try{
					Date birthday = formatter.parse(line[1]);
					person.setBirthday(birthday);
				} catch(Exception e) {
					person.setBirthday(null);
				}
			} else if(line[0].equals("GWA")){
				try{
					person.setGwa(Float.parseFloat(line[1]));
				} catch (Exception e) {
					person.setGwa(0);
				}
			} else if(line[0].equals("Employment Status")){
				person.setEmploymentStatus(line[1]);
			} else if(line[0].equals("Mobile")){
				/*ContactInfo contact = new ContactInfo();
				contact.setContactType("Mobile");
				contact.setContactInfo(line[1]);*/
				contacts.add(new ContactInfo("Mobile", line[1]));
			} else if(line[0].equals("Landline")){
				/*ContactInfo contact = new ContactInfo();
				contact.setContactType("Landline");
				contact.setContactInfo(line[1]);*/
				contacts.add(new ContactInfo("Landline", line[1]));
			} else if(line[0].equals("Email")){
				/*ContactInfo contact = new ContactInfo();
				contact.setContactType("Email");
				contact.setContactInfo(line[1]);*/
				contacts.add(new ContactInfo("Email", line[1]));
			} else if(line[0].equals("Roles")){
				String[] tempRoles = line[1].split(",");
				for(String role : tempRoles){
					roles.add(findRole(role));
				}
			}

			person.setName(name);
			person.setAddress(address);

			if(!roles.isEmpty()){
				person.setRoles(roles);
			}
			if(!contacts.isEmpty()){
				person.setContacts(contacts);
			}
		}
		return person;
	}

	public Role findRole(String roleName){
		Role role = null;
		if(roleName.equals("CEO")){
			role = roleManagerImpl.getRole(1);
		} else if(roleName.equals("CFO")){
			role = roleManagerImpl.getRole(2);
		} else if(roleName.equals("COO")){
			role = roleManagerImpl.getRole(3);
		} else if(roleName.equals("Admin")){
			role = roleManagerImpl.getRole(4);
		} else if(roleName.equals("Manager")){
			role = roleManagerImpl.getRole(5);
		}
		return role;
	}
}
