package com.tridentSoft.devtools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tridentSoft.devtools.dto.CreateCustomerRequest;
import com.tridentSoft.devtools.dto.CustomerResponse;
import com.tridentSoft.devtools.dto.LoginRequest;
import com.tridentSoft.devtools.dto.LoginResponse;
import com.tridentSoft.devtools.service.AuthService;
import com.tridentSoft.devtools.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/devTools/auth")
public class DevToolsAuthController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AuthService authService;

	@PostMapping("/create-update")
	public ResponseEntity<CustomerResponse> createOrUpdate(@RequestBody CreateCustomerRequest request) {

		return ResponseEntity.ok(customerService.createOrUpdateCustomer(request));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

		LoginResponse response = authService.login(request);
		return ResponseEntity.ok(response);
	}

}
