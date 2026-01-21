package com.tridentSoft.devtools.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMockResponse {

	private String mockUrl;
	private LocalDateTime expiresAt;

	private String responseBody;

}
