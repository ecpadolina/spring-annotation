package ecp.spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "CONTACTINFO")
public class ContactInfo{
  
  @Id
  @Column(name = "contact_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int contactId;
  @Column(name = "contact_type")
  private String contactType;
  @Column(name = "contact_info")
  private String contactInfo;
  
  public ContactInfo(){}
  
  public ContactInfo(String contactType, String contactInfo){
    this.contactType = contactType;
    this.contactInfo = contactInfo;
  }
  
  public void setId(int contactId){
    this.contactId = contactId;
  }
  
  public void setContactType(String contactType){
    this.contactType = contactType;
  }
  
  public void setContactInfo(String contactInfo){
    this.contactInfo = contactInfo;
  }
  
  public int getContactId(){
    return contactId;
  }
  
  public String getContactType(){
    return contactType;
  }
  
  public String getContactInfo(){
    return contactInfo;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!this.getClass().equals(obj.getClass())) return false;
      ContactInfo obj2 = (ContactInfo)obj;
      if(this.contactInfo.equals(obj2.getContactInfo())){
        return true;
      }
    return false;
  }
  
  @Override
  public int hashCode() {
    int tmp = 0;
    tmp = ( contactInfo ).hashCode();
    return tmp;
  }
}
