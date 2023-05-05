package com.fps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {
	@Id
	@Column(name = "CUST_ID")
	private Long id;
	@Column(name = "CUST_NAME")
	private String name;
	@Column(name = "CREATED_DATE")
	private Date createdDate;


	
	
}
