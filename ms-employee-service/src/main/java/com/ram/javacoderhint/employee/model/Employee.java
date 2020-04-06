package com.ram.javacoderhint.employee.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "employee")
public class Employee {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	@Transient
	private List<Account> accounts;

	public Employee(List<Account> accounts) {
		this.accounts = accounts;
	}	
}
