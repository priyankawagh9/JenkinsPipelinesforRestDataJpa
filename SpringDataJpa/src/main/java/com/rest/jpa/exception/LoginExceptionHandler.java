package com.rest.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler {
	@ExceptionHandler(value = LoginException.class)
	public ResponseEntity<Object> handleException(LoginException e)
	{
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(Exception e)
	{
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	
}
