package ecp.spring.web;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;

import ecp.spring.model.ContactInfo;
import ecp.spring.model.Person;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.validator.routines.EmailValidator;

@Component
public class PersonValidator implements Validator{

	public boolean supports(Class clazz){
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors){
		Person person = (Person)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name.firstName", "error.name.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name.lastName", "error.name.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name.middleName", "error.name.middleName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "error.birthday");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.houseNo", "error.address.houseNo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.street", "error.address.street");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.subdivision", "error.address.subdivision");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.municipality", "error.address.municipality");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.barangay", "error.address.barangay");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipcode", "error.address.zipcode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.province", "error.address.province");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employmentStatus", "error.employmentStatus");

		/*for(ContactInfo contact : person.getContacts()){
			if(contact.getContactType().equals("Landline")){
				if(!contact.getContactInfo().matches("^[0-9]+(-[0-9]+)*$")){
					errors.rejectValue("contacts", "error.contact.landline");
				}
			}
			else if(contact.getContactType().equals("Mobile")){
				if(!contact.getContactInfo().matches("^[0-9]{11}$"))
					errors.rejectValue("contacts", "error.contact.mobile");
			}
			else {
				if(!EmailValidator.getInstance().isValid(contact.getContactInfo())){
					errors.rejectValue("contacts", "error.contact.email");
				}
			}
		}*/
	}
}