package com.tridentSoft.devtools.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

	private Long customerId;
	private String customerCode;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
