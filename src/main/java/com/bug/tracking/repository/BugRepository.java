package com.bug.tracking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.Bug;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long>{

	Bug findBugById(Long id);

}
