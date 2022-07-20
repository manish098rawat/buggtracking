package com.bug.tracking.service;

import com.bug.tracking.modal.Employee;

public interface EmployeeService {
	
	public Employee saveOrUpdate(Employee bug);
	public Employee findEmployeeById(Long id);
	public Iterable<Employee> findAllEmployee();
	public void deleteEmployeeById(Long id);

}
