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

import com.bug.tracking.modal.Bug;
import com.bug.tracking.service.BugService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

@RestController
@RequestMapping("bugs")
public class BugController {
	
	@Autowired
	private BugService bugService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("add")
	public ResponseEntity<?> createNewBug(@Valid @RequestBody Bug uugEntity,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Bug savedBug = bugService.saveOrUpdate(uugEntity);
		return new ResponseEntity<Bug>(savedBug,HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<?> getBugById(@PathVariable Long id){
			Bug uugEntity=bugService.findBugById(id);
		return new ResponseEntity<Bug>(uugEntity,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public Iterable<Bug> getAllBug(){
	return bugService.findAllBug();
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteBug(@PathVariable Long id){
		bugService.deleteBugById(id);
		return new ResponseEntity<String>("Bug with Id"+id+" deleted Successfully",HttpStatus.OK);
	}

}
