package com.bug.tracking.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String adminName;
	
    @Column(unique = true, nullable = false)
	private String email;
    
	@NotBlank(message="password is required")
	@Column(updatable = false,unique=true)
	private String password;
    
	private String adminContact;

	public Admin(long id, String adminName, String email, String password,String adminContact) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.adminContact = adminContact;
	}

	public Admin(String adminName, String email,String password, String adminContact) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.adminContact = adminContact;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

}
