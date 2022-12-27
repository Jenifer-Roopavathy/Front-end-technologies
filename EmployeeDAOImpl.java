package com.edubridge.springboot.springresthib.dao;

import java.util.List;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.springresthib.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public EmployeeDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Employee> findAll() {
		
		//get the current session
				Session currentSession=entityManager.unwrap(Session.class);
				
				//create the query ,execute and get the result list
				List<Employee>emp=currentSession.createQuery("from Employee",Employee.class).getResultList();
				
				//result the result
				 System.out.println(emp.toString());
				return emp;
			

	}
	//find an employee by id
	
	public Employee findEmployeeById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee emp=session.get(Employee.class,id);
		return emp;
	}

	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query= session.createQuery("delete from Employee where id= :employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
	}

	@Transactional
	public Employee addEmployee(Employee emp) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(emp);
		return emp;
		
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
