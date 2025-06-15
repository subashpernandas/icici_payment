package com.student.validation.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException me){
		Map<String, Object> errorResult = new HashMap<>();
		me.getBindingResult().getFieldErrors()
		.forEach(error ->{
			errorResult.put(error.getField(), error.getDefaultMessage());
		});
		return errorResult;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleValidationException(ConstraintViolationException ex) {
		Map<String, Object> errorResult = new HashMap<>();
		ex.getConstraintViolations()
		.forEach(error -> {
			errorResult.put(error.getPropertyPath().toString(), error.getMessage());
		});
		return errorResult;
	}
}
