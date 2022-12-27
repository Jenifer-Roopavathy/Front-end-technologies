package com.edubridge.springboot.springresthib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.springboot.springresthib.dao.CustomerDAO;
import com.edubridge.springboot.springresthib.entity.Customer;
import com.edubridge.springboot.springresthib.errors.CustomerError;
import com.edubridge.springboot.springresthib.errors.CustomerNotFoundException;
import com.edubridge.springboot.springresthib.service.CustomerService;

@Controller
@RequestMapping("/api")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	

//	@RequestMapping("/")
//	public String first()
//	{
//	System.out.println("in first method");
//	return "hello";
//	}
//	
	@RequestMapping(value="/welcome")
	public String sayHello(Model theModel)
	{      
	theModel.addAttribute("theDate", new java.util.Date());
	return "helloworld";
	}
//	
//	
//	
//	@GetMapping("/employees/{employeeId}")
//	public Employee findEmployeeById(@PathVariable int employeeId)
//	{
//		Employee emp = employeeService.findEmployeeById(employeeId);
//	if(emp == null)
//	{
//		throw new EmployeeNotFoundException("Employee Not Found for employeeId: "+employeeId);
//	}
//	return emp;
//	}
//	
//	@RequestMapping(value="/employees/{employeeId}" , method=RequestMethod.DELETE)
//	public String deleteEmployeeById(@PathVariable int employeeId)
//	{
//		Employee emp = employeeService.findEmployeeById(employeeId);
//	if(emp == null)
//	{
//		throw new EmployeeNotFoundException("Employee Not Found for employeeId: "+employeeId);
//	}
//	employeeService.deleteById(employeeId);
//	return "Deleted Employee is :"+emp.getFirstName();
//	}
//	
	@RequestMapping(value="/cutomers", method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer cus)
	{
		customerService.addCustomer(cus);
	return cus;
	}
//	
//	@RequestMapping(value="/employees", method=RequestMethod.PUT)
//	public Employee updateEmployee(@RequestBody Employee emp)
//	{
//	employeeService.addEmployee(emp);
//	return emp;
//	}
	
	@RequestMapping("/getallcus")
	public String fetchAllCustomers (Model theModel)
	{
		List<Customer> customers=customerService.findAll();
		theModel.addAttribute("customerList", customers);
		return "customerlist";
	}
	
	
	@GetMapping("/showformforadd")
	public String addCustomer(Model theModel)
	{
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customeraddform";
	}
	
	
	
	@RequestMapping(value="/savecus", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer cus)
	{
		customerService.addCustomer(cus);
		return "redirect:/api/getallcus";
				
	}
	
	
	@RequestMapping(value="/showformforupdate")
	public String updateCustomer(@RequestParam("customerId")int id,Model theModel)
	{
		System.out.println("customer Update form for Id="+id);
		Customer cus=customerService.findCustomerById(id);
		theModel.addAttribute("customer",cus);
		return "customeraddform";
				
	}
	
	@RequestMapping(value="/showformfordelete")
	public String deleteCustomer(@RequestParam("customerId")int id,Model theModel)
	{
		System.out.println("Customer Update form for Id="+id);
		Customer cus=customerService.findCustomerById(id);
		if(cus==null)
		{
			throw new CustomerNotFoundException("There is no Customer with the Id:"+id);
		}
		customerService.deleteById(id);
		return "redirect:/api/getallcus";
	}
	
	
	

//	@ExceptionHandler
//	public ResponseEntity<EmployeeError> handleException (EmployeeNotFoundException ex)
//	{
//		EmployeeError err = new EmployeeError();
//		err.setStatus(HttpStatus.NOT_FOUND.value());
//		err.setMessage(ex.getMessage());
//		err.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<EmployeeError> (err, HttpStatus.NOT_FOUND);
//	}
	
	
	
	
	
}