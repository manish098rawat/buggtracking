package com.bug.tracking.service;

import com.bug.tracking.modal.Bug;

public interface BugService {

	public Bug saveOrUpdate(Bug bug);
	public Bug findBugById(Long id);
	public Iterable<Bug> findAllBug();
	public void deleteBugById(Long id);
}
