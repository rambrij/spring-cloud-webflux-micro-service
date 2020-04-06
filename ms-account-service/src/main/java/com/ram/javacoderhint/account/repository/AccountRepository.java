package com.ram.javacoderhint.account.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ram.javacoderhint.account.model.Account;

import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

	Flux<Account> findByCustomerId(String customerId);
	
}
