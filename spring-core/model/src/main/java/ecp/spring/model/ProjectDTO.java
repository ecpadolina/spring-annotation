package ecp.spring.model;

import java.util.Set;
import java.util.Date;

public class ProjectDTO {

    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Set persons;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
    public Set getPersons() {
        return persons;
    }

}
