package com.fps.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fps.model.Customer;
import com.fps.repo.AuthRepository;

@Service
public class AuthService {
	Logger logger = LoggerFactory.getLogger(AuthService.class);
	@Autowired
	private AuthRepository repository;

	public boolean isValidUser(long customerId) {
		logger.debug("Calling DB.");
		Optional<Customer> customer = repository.findById(customerId);
		logger.debug("DB call success.");
		return customer.isPresent() ? true : false;
	}
}
