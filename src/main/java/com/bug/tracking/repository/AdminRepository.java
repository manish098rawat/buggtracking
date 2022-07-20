package com.bug.tracking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	Admin findAdminById(Long id);

}
