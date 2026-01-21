package com.tridentSoft.devtools.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tridentSoft.devtools.domain.MockApiResponse;
import com.tridentSoft.devtools.dto.CreateMockRequest;
import com.tridentSoft.devtools.dto.CreateMockResponse;
import com.tridentSoft.devtools.repository.MockRepository;
import com.tridentSoft.devtools.utilities.PropertyService;

@Service
public class MockService {

	@Autowired
	private MockRepository repository;

	@Autowired
	private PropertyService propService;

	public CreateMockResponse createMock(CreateMockRequest request) {

		String token = UUID.randomUUID().toString().replace("-", "");

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiresAt = now.plusMinutes(propService.getIntProperty("devtools.mockExpMinutesFree", 0));

		MockApiResponse entity = new MockApiResponse();
		entity.setUsername(request.getUsername());
		entity.setToken(token);
		entity.setResponseBody(request.getResponseBody());
		entity.setResponseStatus(request.getStatusCode());
		entity.setResponseHeaders(request.getHeaders().toString());
		entity.setCreatedAt(now);
		entity.setExpiresAt(expiresAt);

		repository.save(entity);
		String mockUrl = propService.getProperty("devtools.mockApiBaseUrl", "") +request.getUsername() +"/" + token;
		return new CreateMockResponse(mockUrl, expiresAt, request.getResponseBody());
	}

	public MockApiResponse findMock(String username, String token) {
		MockApiResponse mock = new MockApiResponse();
		Optional<MockApiResponse> mockOpt = repository.findByUsernameAndToken(username, token);
		if (mockOpt.isPresent()) {
			mock = mockOpt.get();

			ObjectMapper mapper = new ObjectMapper();
			ObjectNode json = mapper.createObjectNode();
			json.put("status", 1);
			json.put("description", "mock service not available");

			if (LocalDateTime.now().isAfter(mock.getExpiresAt())) {
				json.put("status", 1);
				json.put("description", "mock service expired");
				mock.setResponseBody(json.toString());
			}
			else if (mock.getHitCount() > propService.getIntProperty("devtools.hitCountFree", 0)) {
				json.put("status", 1);
				json.put("description", "Maximum hits reached");
				mock.setResponseBody(json.toString());
			}
			else
			{
				incrementHitCount(username, token);
			}

			return mock;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode json = mapper.createObjectNode();
			json.put("status", 1);
			json.put("description", "mock service not available");
			mock.setResponseBody(json.toString());
			return mock;
		}

	}

	public void incrementHitCount(String username, String token) {

		Optional<MockApiResponse> resOpt = repository.findByUsernameAndToken(username, token);
		if (resOpt.isPresent()) {
			MockApiResponse res = new MockApiResponse();
			res = resOpt.get();
			res.setHitCount(res.getHitCount() + 1);
			repository.save(res);
		}

	}

}
