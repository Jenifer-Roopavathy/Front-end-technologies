package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Customer;


public interface CustomerDAO {
		
		 List<Customer>findAll();
		 
		 public Customer findCustomerById(int id);
//		 
		 Customer addCustomer(Customer emp);
//		 
		 void deleteById(int id);	
		
}
	

