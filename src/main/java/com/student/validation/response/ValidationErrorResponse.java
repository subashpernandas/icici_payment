package com.student.validation.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {

	//private String message;
	//private List<String> errors;
	private Map<String, Object> errors;
}
