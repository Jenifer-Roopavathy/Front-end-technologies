package com.edubridge.springboot.springresthib.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<CustomerError> handleException (CustomerNotFoundException ex)
	{
		CustomerError err = new CustomerError();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerError> (err, HttpStatus.NOT_FOUND);
	}
	
}
