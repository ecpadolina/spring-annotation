package ecp.spring.model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Embedded;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Cacheable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "person")
public class Person{
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Embedded
  private Name name;
  @Embedded
  private Address address;
  @Column(name = "gwa")
  private float gwa;
  @Temporal(TemporalType.DATE)
  @Column(name = "birthday")
  private Date birthday;
  @Column(name = "employment_status")
  private String employmentStatus;
  @OneToMany(fetch = FetchType.EAGER, 
             cascade = CascadeType.ALL, 
             orphanRemoval = true)
  @JoinColumn(name="person_id")
  private Set<ContactInfo> contacts;
  @ManyToMany(fetch = FetchType.EAGER, 
              cascade = CascadeType.PERSIST)
  @JoinTable(name="person_role", 
             joinColumns = @JoinColumn(name = "person_id"), 
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @ManyToMany(mappedBy = "persons", fetch = FetchType.LAZY)
  private Set<Project> projects;

  public Person(){}
  
  public void setId(int id){
    this.id = id;
  }
  
  public int getId(){
    return id;
  }
  
  public void setName(Name name){
    this.name = name;
  }
  
  public Name getName(){
    return this.name;
  }
  
  public void setBirthday(Date birthday){
    this.birthday = birthday;
  }
  
  public Date getBirthday(){
    return birthday;
  }
  
  public void setAddress(Address address){
    this.address = address;
  }
  
  public Address getAddress(){
    return address;
  }
  
  public void setGwa(float gwa){
    this.gwa = gwa;
  }
  
  public float getGwa(){
    return gwa;
  }
  
  public void setEmploymentStatus(String employmentStatus){
    this.employmentStatus = employmentStatus;
  }
  
  public String getEmploymentStatus(){
    return employmentStatus;
  }
  
  public void setContacts(Set<ContactInfo> contacts){
    if(this.contacts == null){
      this.contacts = contacts;
    } else {
      this.contacts = new HashSet<ContactInfo>();
      this.contacts.addAll(contacts);
    }
  }
  
  public Set<ContactInfo> getContacts(){
    return contacts;
  }
  
  public void setRoles(Set<Role> roles){
    this.roles = roles;
  }
  
  public Set<Role> getRoles(){
    return roles;
  }
}