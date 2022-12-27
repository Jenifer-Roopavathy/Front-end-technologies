package com.edubridge.springboot.springresthib.errors;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String message)
	{
		super(message);
	}

}
