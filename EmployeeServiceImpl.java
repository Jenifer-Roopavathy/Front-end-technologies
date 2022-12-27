package com.edubridge.springboot.springresthib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.springboot.springresthib.dao.EmployeeDAO;
import com.edubridge.springboot.springresthib.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}
	
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Transactional
	public Employee findEmployeeById(int id) {
		return employeeDAO.findEmployeeById(id);
		
	}

	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
		
	}

	@Transactional
	public Employee addEmployee(Employee emp) {
		return employeeDAO.addEmployee(emp);
		
	}

//	@Transactional
//	public void deleteById(int id) {
//		employeeDAO.deleteById(id);
//		
//	}

//	@Transactional
//	public void findEmployeeById(int id)
//	{
//	
//		employeeDAO.findAll();
//	}
//
//	@Transactional
//	public void addEmployee(Employee emp) {
//		employeeDAO.addEmployee(emp);
//		
//	}
//
//	@Transactional
//	public void deleteById(int id) {
//		employeeDAO.deleteById(id);
//	}

	


}
	