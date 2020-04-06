package com.ram.javacoderhint.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.ram.javacoderhint.employee.model.Account;
import com.ram.javacoderhint.employee.model.Employee;
import com.ram.javacoderhint.employee.model.EmployeeMapper;
import com.ram.javacoderhint.employee.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
    private WebClient.Builder webClientBuilder;

	@GetMapping("/{id}")
	public Mono<Employee> findById(@PathVariable("id") String id) {
		log.info("findById: id={}", id);
		return repository.findById(id);
	}

	@GetMapping
	public Flux<Employee> findAll() {
		log.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/{id}/with-accounts")
	public Mono<Employee> findByIdWithAccounts(@PathVariable("id") String id) {
		log.info("findByIdWithAccounts: id={}", id);
		Flux<Account> accounts = webClientBuilder.build().get().uri("http://ms-account-service/customer/{customer}", id).retrieve().bodyToFlux(Account.class);		
		return accounts
				.collectList()
				.map(a -> new Employee(a))
				.mergeWith(repository.findById(id))
				.collectList()
				.map(EmployeeMapper::map);
	}

	@PostMapping
	public Mono<Employee> create(@RequestBody Employee customer) {
		log.info("create: {}", customer);
		return repository.save(customer);
	}
	
}
