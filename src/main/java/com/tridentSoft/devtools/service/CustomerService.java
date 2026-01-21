package com.tridentSoft.devtools.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tridentSoft.devtools.domain.Customer;
import com.tridentSoft.devtools.dto.CreateCustomerRequest;
import com.tridentSoft.devtools.dto.CustomerResponse;
import com.tridentSoft.devtools.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	public CustomerResponse createOrUpdateCustomer(CreateCustomerRequest req) {

		LocalDateTime now = LocalDateTime.now();
		Customer customer;

		if (req.getCustomerId() == null) {

			customer = new Customer();
			customer.setCustomerCode(generateCustomerCode());
			customer.setCreatedAt(now);
			customer.setStatus("ACTIVE");
			// customer.setPassword(passwordEncoder.encode(req.getPassword()));
			customer.setPassword(req.getPassword());
		} else {

			customer = repository.findById(req.getCustomerId())
					.orElseThrow(() -> new RuntimeException("Customer not found"));
			customer.setUpdatedAt(now);
			if (req.getPassword() != null && !req.getPassword().isBlank()) {
				// customer.setPassword(passwordEncoder.encode(req.getPassword()));
				customer.setPassword(req.getPassword());
			}
		}

		customer.setCustomerType(req.getCustomerType());
		customer.setCustName(req.getCustName());
		customer.setEmail(req.getEmail());
		customer.setMobileNumber(req.getMobileNumber());
		customer.setAccountType(req.getAccountType());
		customer.setCountryCode(req.getCountryCode());

		Customer saved = repository.save(customer);

		return new CustomerResponse(saved.getCustomerId(), saved.getCustomerCode(), saved.getStatus(),
				saved.getCreatedAt(), saved.getUpdatedAt());
	}

	private String generateCustomerCode() {
		long number = 1000000000L + new Random().nextLong(9000000000L);
		return String.valueOf(number);
	}
}
