package com.bug.tracking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.EmployeeIdException;
import com.bug.tracking.modal.Employee;
import com.bug.tracking.repository.EmployeeRepository;
import com.bug.tracking.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		try{
			employee.setId(employee.getId());
			return employeeRepository.save(employee);
		}catch(Exception ex) {
			throw new EmployeeIdException("Employee Id : "+ employee.getId() +"already exists");
		}
		
	}
	@Override
	public Employee findEmployeeById(Long id) {
		Employee employee=employeeRepository.findEmployeeById(id);
		if(employee == null)
			throw new EmployeeIdException("Employee Id " + id +" does not exist");
		return employee;
	}
	@Override
	public Iterable<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee = employeeRepository.findEmployeeById(id);
		if(employee == null)
			throw new EmployeeIdException("Employee Id " + id +" does not exist");
		employeeRepository.delete(employee);
		
	}

}
