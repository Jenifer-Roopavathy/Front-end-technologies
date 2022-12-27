package com.edubridge.springboot.springresthib.service;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findEmployeeById(int id);
	public Employee addEmployee(Employee emp);
	public void deleteById(int id);

}
