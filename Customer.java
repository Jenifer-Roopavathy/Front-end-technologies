package com.edubridge.springboot.springresthib.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
	private int id;
	@Column(name="section")
	private String section;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private int age ;
	@Column(name="phno")
	private int phno;
	
	
	
	public Customer()
	{
		
	}
	public Customer(String section,String firstName, String lastName, String email,int age,int phno ) {
	
		this.section=section;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age=age;
		this.phno=phno;
		
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ",section= " + section + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", age= " + age +", phno= " + phno + "]";
	}
	
}
