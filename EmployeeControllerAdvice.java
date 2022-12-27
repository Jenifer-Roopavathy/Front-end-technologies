package com.edubridge.springboot.springresthib.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<EmployeeError> handleException (EmployeeNotFoundException ex)
	{
		EmployeeError err = new EmployeeError();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeError> (err, HttpStatus.NOT_FOUND);
	}
	
}
