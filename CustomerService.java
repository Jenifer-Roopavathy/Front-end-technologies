package com.edubridge.springboot.springresthib.service;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	public Customer findCustomerById(int id);
	public Customer addCustomer(Customer emp);
	public void deleteById(int id);

}
