package com.edubridge.springboot.springresthib.errors;

public class EmployeeError {
	
	//fields
	int status;
	String message;
	Long timeStamp;
	
	//generate constructor
	public EmployeeError()
	{
		
	}
	
	//generate constructor using fields
	public EmployeeError(int status, String message, Long timeStamp) {
		
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		
	}
	//generate getters and setters

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
