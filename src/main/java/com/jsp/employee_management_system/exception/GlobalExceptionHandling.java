package com.jsp.employee_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OtpExpireException.class)
	public ResponseEntity<String> otpExpire(OtpExpireException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
