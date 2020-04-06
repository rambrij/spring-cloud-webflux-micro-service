package com.ram.javacoderhint.employee.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ram.javacoderhint.employee.model.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
	
}
