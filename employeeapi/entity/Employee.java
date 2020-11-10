package employeeapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
 
@Entity
public class Employee implements Serializable {
       
    /**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String firstName;
    private String surName;
    private String jobTitle;
    private Date joiningDate;
    private Integer payAmount;
   
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public Date getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    public Integer getPayAmount() {
    	return payAmount;
    }
    public void setPayAmount(Integer payAmount) {
    	this.payAmount = payAmount;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}