package com.edubridge.springboot.springresthib.errors;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String message)
	{
		super(message);
	}

}
