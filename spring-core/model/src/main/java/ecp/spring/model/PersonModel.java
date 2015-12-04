package ecp.spring.model;

import java.util.Date;

public class PersonModel{
	private int id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private float gwa;
	private String contactInfo;

	public int getId(){
		return this.id;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public Date getBirthday(){
		return this.birthday;
	}

	public float getGwa(){
		return this.gwa;
	}

	public String getContactInfo(){
		return this.contactInfo;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	public void setGwa(float gwa){
		this.gwa = gwa;
	}

	public void setContactInfo(String contactInfo){
		this.contactInfo = contactInfo;
	}
}