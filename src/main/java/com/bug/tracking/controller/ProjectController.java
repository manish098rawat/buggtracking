package com.bug.tracking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.tracking.modal.Project;
import com.bug.tracking.service.ProjectService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

@RestController
@RequestMapping("projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("add")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Project savedProject = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(savedProject,HttpStatus.CREATED);
	}
	@GetMapping("view/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
			Project project=projectService.findProjectByIdentifier(projectId);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public Iterable<Project> getAllProjects(){
	return projectService.findAllProject();
}
	@DeleteMapping("delete/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId){
		projectService.deleteProjectByProjectIdentifier(projectId);
		return new ResponseEntity<String>("Project with Id"+projectId.toUpperCase()+" deleted Successfully",HttpStatus.OK);
	}
}

