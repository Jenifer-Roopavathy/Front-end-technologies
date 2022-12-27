package com.edubridge.springboot.springresthib.dao;

import java.util.List;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.springresthib.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public CustomerDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Customer> findAll() {
		
		//get the current session
				Session currentSession=entityManager.unwrap(Session.class);
				
				//create the query ,execute and get the result list
				List<Customer>cus=currentSession.createQuery("from Customer",Customer.class).getResultList();
				
				//result the result
				 System.out.println(cus.toString());
				return cus;
			

	}
	//find an employee by id
	
	public Customer findCustomerById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Customer cus=session.get(Customer.class,id);
		return cus;
	}

	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query= session.createQuery("delete from Customer where id= :customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

	@Transactional
	public Customer addCustomer(Customer cus) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(cus);
		return cus;
		
	}

	//delete emp by id
//	public void delectById(int id) {
//		Session session=entityManager.unwrap(Session.class);
//		session.remove(id);
//		Query query=session.createQuery("delete from Employee where id=:employeeId");
//		query.setParameter("employeeId", id);
//		query.executeUpdate();
//		
//	}

	//Add a new employee
//	@Transactional
//	public void addEmployee(Employee emp) {
//		Session session=entityManager.unwrap(Session.class);	
//		session.saveOrUpdate(emp);
//	}
	
	//delete an employee by id
//	@Transactional
//	public void delectById(int id) {
//		Session session=entityManager.unwrap(Session.class);
//		session.remove(id);
//		Query query=session.createQuery("delete from Employee where id=:employeeId");
//		query.setParameter("employeeId", id);
//		query.executeUpdate();
//	
//		
//	}
	
	

}
