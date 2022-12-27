package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Employee;


public interface EmployeeDAO {
		
		 List<Employee>findAll();
		 
		 public Employee findEmployeeById(int id);
//		 
		 Employee addEmployee(Employee emp);
//		 
		 void deleteById(int id);	
		
}
	

