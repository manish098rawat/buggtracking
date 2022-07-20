package com.bug.tracking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.BugIdException;
import com.bug.tracking.modal.Bug;
import com.bug.tracking.repository.BugRepository;
import com.bug.tracking.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	@Autowired
	private BugRepository bugRepository;
	@Override
	public Bug saveOrUpdate(Bug bug) {
		// TODO Auto-generated method stub
		try{
			bug.setId(bug.getId());
			return bugRepository.save(bug);
		}catch(Exception ex) {
			throw new BugIdException("Bug Id : "+ bug.getId() +"already exists");
		}
		
	}
	@Override
	public Bug findBugById(Long id) {
		Bug bug=bugRepository.findBugById(id);
		if(bug == null)
			throw new BugIdException("Bug Id " + id +" does not exist");
		return bug;
	}
	@Override
	public Iterable<Bug> findAllBug() {
		// TODO Auto-generated method stub
		return bugRepository.findAll();
	}
	@Override
	public void deleteBugById(Long id) {
		Bug bug = bugRepository.findBugById(id);
		if(bug == null)
			throw new BugIdException("Bug Id " + id +" does not exist");
		bugRepository.delete(bug);
		
	}
	
}
