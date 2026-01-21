package com.tridentSoft.devtools.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer", schema = "devtools")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_code", nullable = false, unique = true)
	private String customerCode;

	@Column(name = "customer_type", nullable = false)
	private String customerType;

	@Column(name = "cust_name")
	private String custName;

	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "country_code")
	private String countryCode;

	private String status;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "password", nullable = false)
	private String password;

}
