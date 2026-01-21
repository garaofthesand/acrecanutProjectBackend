package com.tridentSoft.devtools.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateMockRequest {

	private String username;
	private String responseBody;
	private Integer statusCode = 200;
	private Map<String, String> headers;
	private Integer ttlMinutes;

}
