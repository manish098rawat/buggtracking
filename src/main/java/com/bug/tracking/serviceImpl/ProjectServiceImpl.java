package com.bug.tracking.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.ProjectIdException;
import com.bug.tracking.modal.Project;
import com.bug.tracking.repository.ProjectRepository;
import com.bug.tracking.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public Project saveOrUpdate(Project project) {
		// TODO Auto-generated method stub
		try{
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch(Exception ex) {
			throw new ProjectIdException("Project Id : "+project.getProjectIdentifier().toUpperCase()+"already exists");
		}
		
	}
	@Override
	public Project findProjectByIdentifier(String projectId) {
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null)
			throw new ProjectIdException("Project Id " + projectId.toUpperCase()+" does not exist");
		return project;
	}
	@Override
	public Iterable<Project> findAllProject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}
	@Override
	public void deleteProjectByProjectIdentifier(String projectId) {
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null)
			throw new ProjectIdException("Project Id " + projectId.toUpperCase()+" does not exist");
		projectRepository.delete(project);
		
	}
	

}

