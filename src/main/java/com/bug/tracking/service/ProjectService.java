package com.bug.tracking.service;

import com.bug.tracking.modal.Project;

public interface ProjectService {
public Project saveOrUpdate(Project project);
public Project findProjectByIdentifier(String projectId);
public Iterable<Project> findAllProject();
public void deleteProjectByProjectIdentifier(String projectId);
}
