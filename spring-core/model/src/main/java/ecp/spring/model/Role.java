package ecp.spring.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role{

  @Id
  @Column(name = "role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleId;
  @Column(name = "role_type")
  private String roleType;
  @ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
  @JsonIgnore
  private Set<Person> persons;
  
  public Role(){}

  public void setRoleId(int roleId){
    this.roleId = roleId;
  }
  
  public void setRoleType(String roleType){
    this.roleType = roleType;
  }
  
  public void setPersons(Set<Person> persons){
    this.persons = persons;
  }
  
  public int getRoleId(){
    return roleId;
  }
  
  public String getRoleType(){
    return roleType;
  }
  
  public Set<Person> getPersons(){
    return persons;
  }

	@Override	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;
		Role obj2 = (Role)obj;
		if(this.roleId == obj2.getRoleId()){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.roleId;
	}
  
}
