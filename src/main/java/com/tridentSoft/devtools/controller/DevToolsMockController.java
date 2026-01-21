package com.tridentSoft.devtools.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tridentSoft.devtools.domain.MockApiResponse;
import com.tridentSoft.devtools.dto.CreateMockRequest;
import com.tridentSoft.devtools.dto.CreateMockResponse;
import com.tridentSoft.devtools.service.MockService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/devTools")
public class DevToolsMockController {

	@Autowired
	private MockService mockService;


	@PostMapping("/api/v1/mock")
	public ResponseEntity<CreateMockResponse> createMock(@RequestBody CreateMockRequest request) {

		CreateMockResponse response = mockService.createMock(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/mock/{username}/{token}")
	public ResponseEntity<String> hitMock(@PathVariable String username, @PathVariable String token) {

		MockApiResponse mock = mockService.findMock(username, token);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

		int status = mock.getResponseStatus() != null && mock.getResponseStatus() > 0 ? mock.getResponseStatus()
				: HttpStatus.OK.value();

		return new ResponseEntity<>(mock.getResponseBody(), headers, HttpStatus.valueOf(status));
	}
}
