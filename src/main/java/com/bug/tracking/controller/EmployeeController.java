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

import com.bug.tracking.modal.Employee;
import com.bug.tracking.service.EmployeeService;
import com.bug.tracking.serviceImpl.ErrorMapValidationService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService;  
	@PostMapping("add")
	public ResponseEntity<?> createNewEmployee(@Valid @RequestBody Employee uugEntity,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Employee savedEmployee = employeeService.saveOrUpdate(uugEntity);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
			Employee uugEntity=employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(uugEntity,HttpStatus.OK);
		}
	@GetMapping("viewall")
	public Iterable<Employee> getAllEmployee(){
	return employeeService.findAllEmployee();
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee with Id"+id+" deleted Successfully",HttpStatus.OK);
	}


}
