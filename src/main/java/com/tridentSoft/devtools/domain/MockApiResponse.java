package com.tridentSoft.devtools.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "mock_api_response", schema = "dbo", uniqueConstraints = @UniqueConstraint(columnNames = { "username",
		"token" }))

@Data
public class MockApiResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String token;

	@Column(columnDefinition = "TEXT", nullable = false, name = "response_body")
	private String responseBody;

	@Column(columnDefinition = "TEXT", nullable = false, name = "response_status")
	private Integer responseStatus;

	@Column(columnDefinition = "TEXT", nullable = false, name = "response_headers")
	private String responseHeaders;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "expires_at", nullable = false)
	private LocalDateTime expiresAt;

	@Column(name = "hit_count", nullable = false)
	private Integer hitCount = 0;

}
