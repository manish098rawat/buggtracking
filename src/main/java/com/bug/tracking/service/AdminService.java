package com.bug.tracking.service;

import com.bug.tracking.modal.Admin;

public interface AdminService {
	
	public Admin saveOrUpdate(Admin admin);
	public Admin findAdminById(Long id);
	public Iterable<Admin> findAllAdmin();
	public void deleteAdminById(Long id);


}
