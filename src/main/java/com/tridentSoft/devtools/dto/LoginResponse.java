package com.tridentSoft.devtools.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

	private int status; // 0 = success, 1 = failure
	private String message;

	private Long customerId;
	private String customerCode;
	private String customerType;
	private String email;
	private LocalDateTime loginTime;

	public LoginResponse(int status, String message) {
		this.status = status;
		this.message = message;
		this.loginTime = LocalDateTime.now();
	}

	public LoginResponse(int status, String message, Long customerId, String customerCode, String customerType,
			String email) {
		this.status = status;
		this.message = message;
		this.customerId = customerId;
		this.customerCode = customerCode;
		this.customerType = customerType;
		this.email = email;
		this.loginTime = LocalDateTime.now();
	}
}
