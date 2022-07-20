package com.bug.tracking.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String bugName;
	private String bugDescription;
	
	@OneToOne
	private Project project;
	
	private Boolean bugStatus = true;

	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bug(String bugName, String bugDescription, Project project, Boolean bugStatus) {
		super();
		this.bugName = bugName;
		this.bugDescription = bugDescription;
		this.project = project;
		this.bugStatus = bugStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Boolean getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(Boolean bugStatus) {
		this.bugStatus = bugStatus;
	}
	
}
