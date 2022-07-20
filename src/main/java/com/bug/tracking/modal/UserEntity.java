package com.bug.tracking.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="UserEntity Name is required")
	@Column(updatable = false,unique=true)
	private String userName;
	
	@NotBlank(message="password is required")
	@Column(updatable = false,unique=true)
	private String password;
	
	@NotBlank(message="UserEntity email is required")
	@Column(updatable = false,unique=true)
	private String email;
	
	@OneToOne
	private Project project;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(long id, String userName, String password, String email, Project project) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.project=project;
	}

	public UserEntity(String userName, String password, String email, Project project) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.project=project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
