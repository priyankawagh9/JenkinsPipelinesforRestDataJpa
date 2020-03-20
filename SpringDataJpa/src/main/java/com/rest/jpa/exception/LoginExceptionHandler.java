package com.rest.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler {
	@ExceptionHandler(value = LoginException.class)
	public ResponseEntity<String> handleException(LoginException e)
	{
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(Exception e)
	{
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	
}
