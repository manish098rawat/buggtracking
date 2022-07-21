package com.bug.tracking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.AdminIdException;
import com.bug.tracking.modal.Admin;
import com.bug.tracking.repository.AdminRepository;
import com.bug.tracking.service.AdminService;

@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin saveOrUpdate(Admin admin) {
		// TODO Auto-generated method stub
		try{
			return adminRepository.save(admin);
		}catch(Exception ex) {
			throw new AdminIdException("Admin Id : "+ admin.getId() +"already exists");
		}
		
	}
	@Override
	public Admin findAdminById(Long id) {
		Admin admin=adminRepository.findAdminById(id);
		if(admin == null)
			throw new AdminIdException("Admin Id " + id +" does not exist");
		return admin;
	}
	@Override
	public Iterable<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
	@Override
	public void deleteAdminById(Long id) {
		Admin admin = adminRepository.findAdminById(id);
		if(admin == null)
			throw new AdminIdException("Admin Id " + id +" does not exist");
		adminRepository.delete(admin);
	}
		

}
