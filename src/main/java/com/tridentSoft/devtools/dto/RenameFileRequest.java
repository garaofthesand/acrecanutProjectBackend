package com.tridentSoft.devtools.dto;

import lombok.Data;

@Data
public class RenameFileRequest {

	private String username;
	private String filenameOld;
	private String filenameNew;

}
