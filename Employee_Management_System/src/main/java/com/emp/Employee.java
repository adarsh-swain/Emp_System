package com.emp;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private int employeeid;
    private String name;
    private String designation;
    private String address;
    private int gender;
    private LocalDate birthday;
    private BigDecimal salary;
    
    
    
    
	public Employee() {
	
	}


	

	public Employee(int employeeid, String name, String designation, String address, int gender, LocalDate birthday,
			BigDecimal salary) {
		this.employeeid = employeeid;
		this.name = name;
		this.designation = designation;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
	}




	public BigDecimal getSalary() {
		return salary;
	}




	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}




	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
    
    
}
