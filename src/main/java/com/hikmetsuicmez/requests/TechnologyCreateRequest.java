package com.hikmetsuicmez.requests;

import lombok.Data;

@Data
public class TechnologyCreateRequest {
	
	Long id;
	String technologyName;
	String text;
	Long languageId;
}
