package com.bug.tracking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	Employee findEmployeeById(Long id);

}
