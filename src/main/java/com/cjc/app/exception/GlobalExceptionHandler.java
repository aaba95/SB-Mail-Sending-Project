package com.cjc.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public String userAlreadyExistsException(UserAlreadyExistsException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(NoSuchUserExistsException.class)
	public String noSuchUserExistsException(NoSuchUserExistsException e) {
		return e.getMessage();
	}
}
