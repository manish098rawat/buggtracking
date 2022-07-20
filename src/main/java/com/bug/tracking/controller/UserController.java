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

import com.bug.tracking.modal.UserEntity;
import com.bug.tracking.service.UserService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("add")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody UserEntity userEntity,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		UserEntity savedUser = userService.saveOrUpdate(userEntity);
		return new ResponseEntity<UserEntity>(savedUser,HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id){
			UserEntity userEntity=userService.findUserById(id);
		return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public Iterable<UserEntity> getAllUser(){
	return userService.findAllUser();
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		userService.deleteUserById(id);
		return new ResponseEntity<String>("UserEntity with Id"+id+" deleted Successfully",HttpStatus.OK);
	}
}
