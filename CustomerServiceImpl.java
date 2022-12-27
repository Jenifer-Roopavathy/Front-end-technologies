 package com.edubridge.springboot.springresthib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.springboot.springresthib.dao.CustomerDAO;
import com.edubridge.springboot.springresthib.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO)
	{
		this.customerDAO = customerDAO;
	}
	
	@Transactional
	public List<Customer> findAll() {
		
		return customerDAO.findAll();
	}

	@Transactional
	public Customer findCustomerById(int id) {
		return customerDAO.findCustomerById(id);
		
	}

	@Transactional
	public void deleteById(int id) {
		customerDAO.deleteById(id);
		
	}

	@Transactional
	public Customer addCustomer(Customer emp) {
		return customerDAO.addCustomer(emp);
		
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
	