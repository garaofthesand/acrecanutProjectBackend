package com.tridentSoft.devtools.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tridentSoft.devtools.domain.Customer;
import com.tridentSoft.devtools.dto.LoginRequest;
import com.tridentSoft.devtools.dto.LoginResponse;
import com.tridentSoft.devtools.repository.CustomerRepository;

@Service
public class AuthService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	public LoginResponse login(LoginRequest request) {

		Optional<Customer> optionalCustomer = customerRepository.findByEmail(request.getEmail());

		if (optionalCustomer.isEmpty()) {
			return new LoginResponse(1, "Invalid email or password");
		}

		Customer customer = optionalCustomer.get();

		if (!"ACTIVE".equalsIgnoreCase(customer.getStatus())) {
			return new LoginResponse(1, "Account is not active");
		}

		/*
		 * if (!passwordEncoder.matches(request.getPassword(), customer.getPassword()))
		 * { return new LoginResponse(1, "Invalid email or password"); }
		 */
		
		
		if (!request.getPassword().equals(customer.getPassword())) {
		    return new LoginResponse(1, "Invalid email or password");
		}


		return new LoginResponse(0, "Login successful", customer.getCustomerId(), customer.getCustomerCode(),
				customer.getCustomerType(), customer.getEmail());
	}

}
