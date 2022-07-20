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

import com.bug.tracking.modal.Admin;
import com.bug.tracking.service.AdminService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("add")
	public ResponseEntity<?> createNewAdmin(@Valid @RequestBody Admin uugEntity,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Admin savedAdmin = adminService.saveOrUpdate(uugEntity);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable Long id){
			Admin uugEntity=adminService.findAdminById(id);
		return new ResponseEntity<Admin>(uugEntity,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public Iterable<Admin> getAllAdmin(){
	return adminService.findAllAdmin();
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Long id){
		adminService.deleteAdminById(id);
		return new ResponseEntity<String>("Admin with Id"+id+" deleted Successfully",HttpStatus.OK);
	}


	

}
