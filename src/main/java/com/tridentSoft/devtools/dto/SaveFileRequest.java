package com.tridentSoft.devtools.dto;

import lombok.Data;

@Data
public class SaveFileRequest {

	private String username;
	private String filename;
	private String content;
}
