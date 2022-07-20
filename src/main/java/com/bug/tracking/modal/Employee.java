package com.bug.tracking.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String employeeName;
	
    @Column(unique = true, nullable = false)
	private String email;
    
	@NotBlank(message="password is required")
	@Column(updatable = false,unique=true)
	private String password;
    
	private String employeeContact;
	
	@OneToOne
	private Bug bug;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String employeeName, String email, String password, String employeeContact, Bug bug) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
		this.employeeContact = employeeContact;
		this.bug = bug;
	}

	public Employee(String empName, String email, String password, String empContact, Bug bug) {
		super();
		this.employeeName = empName;
		this.email = email;
		this.password = password;
		this.employeeContact = empContact;
		this.bug = bug;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String empName) {
		this.employeeName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String empContact) {
		this.employeeContact = empContact;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}
	
}
