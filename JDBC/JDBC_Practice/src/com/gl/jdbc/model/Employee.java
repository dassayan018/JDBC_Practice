package com.gl.jdbc.model;

public class Employee {
	
	String employeeID;
	String employeeName;
	String employeeAddress;
	String employeePhone;
	int employeeSalary;
	double profTax;
	
	
	
	public Employee() {
		super();
	}



	public Employee(String employeeID, String employeeName, String employeeAddress, String employeePhone,
			int employeeSalary, double profTax) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
		this.profTax = profTax;
	}



	public String getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeeAddress() {
		return employeeAddress;
	}



	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}



	public String getEmployeePhone() {
		return employeePhone;
	}



	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}



	public int getEmployeeSalary() {
		return employeeSalary;
	}



	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}



	public double getProfTax() {
		return profTax;
	}



	public void setProfTax(double profTax) {
		this.profTax = profTax;
	}



	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + ", employeePhone=" + employeePhone + ", employeeSalary=" + employeeSalary
				+ ", profTax=" + profTax + "]";
	}
	
	
	

}
