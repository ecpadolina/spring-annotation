package ecp.spring.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Name{
  
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;

  public Name(String lastName, String firstName, String middleName){
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
  }
  
  public Name(){}
  
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  
  public  void setFirstName(String firstName){
    this.firstName = firstName;
  }
  
  public void setMiddleName(String middleName){
    this.middleName = middleName;
  }
  
  public String getLastName(){
    return lastName;
  }
  
  public String getFirstName(){
    return firstName;
  }  
  
  public String getMiddleName(){
    return middleName;
  }
  
  public String toString(){
    return getLastName() + ", " + getFirstName();
  }
}
