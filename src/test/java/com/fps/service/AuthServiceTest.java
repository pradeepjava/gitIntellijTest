package com.fps.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fps.model.Customer;
import com.fps.repo.AuthRepository;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

	@Mock
	private AuthRepository repo;
	@InjectMocks
	private AuthService service;

	@Test
	public void userAvailable() {

		when(repo.findById(1l)).thenReturn(Optional.of(getCustomer(1)));
		assertEquals(service.isValidUser(1l), true);
	}

	@Test
	public void userNotAvailable() {

		when(repo.findById(1l)).thenReturn(Optional.empty());
		assertEquals(service.isValidUser(1l), false);
	}
	
	private Customer getCustomer(long id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setCreatedDate(new Date());
		customer.setName("pradeep");
		return customer;
	}

}
