package com.tridentSoft.devtools.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

	private Long customerId;
	private String customerType;
	private String custName;
	private String email;
	private String mobileNumber;
	private String accountType;
	private String countryCode;
	private String token;
	private String password; 

}
