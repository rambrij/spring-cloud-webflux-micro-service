package com.ram.javacoderhint.employee.model;

import java.util.List;

public class EmployeeMapper {

	public static Employee map(List<Employee> customers) {
		Employee customer = new Employee();
		for (Employee c : customers) {
			if (c.getAccounts() != null) customer.setAccounts(c.getAccounts());
			if (c.getAge() != 0) customer.setAge(c.getAge());
			if (c.getFirstName() != null) customer.setFirstName(c.getFirstName());
			if (c.getLastName() != null) customer.setFirstName(c.getLastName());
		}
		return customer;
	}
	
}
