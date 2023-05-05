package com.fps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fps.model.Customer;

public interface AuthRepository extends JpaRepository<Customer, Long> {

}
