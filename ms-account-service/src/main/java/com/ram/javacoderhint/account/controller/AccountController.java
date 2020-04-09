package com.ram.javacoderhint.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.javacoderhint.account.model.Account;
import com.ram.javacoderhint.account.repository.AccountRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class AccountController {

	
	@Autowired
	private AccountRepository repository;

	@GetMapping("/customer/{customer}")
	public Flux<Account> findByCustomer(@PathVariable("customer") String customerId) {
		log.info("findByCustomer: customerId={}", customerId);
		return repository.findByCustomerId(customerId);
	}

	@GetMapping
	public Flux<Account> findAll() {
		log.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Account> findById(@PathVariable("id") String id) {
		log.info("findById: id={}", id);
		return repository.findById(id);
	}

	@PostMapping
	public Mono<Account> create(@RequestBody Account account) {
		log.info("create: {}", account);
		return repository.save(account);
	}
	
}
