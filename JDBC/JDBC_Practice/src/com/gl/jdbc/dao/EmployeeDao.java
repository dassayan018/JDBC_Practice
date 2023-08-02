package com.gl.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gl.jdbc.model.Employee;
import com.gl.jdbc.myconnections.MyConnection;


public class EmployeeDao {
	
	
	Connection myCon;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MyConnection mCon;
	public EmployeeDao() {
		mCon = new MyConnection();
	}
	
	public ArrayList<Employee> getEmployees()
	{
		myCon = mCon.getMyConnection();
		try {
			String query = "select * from employees";
			stmt = myCon.createStatement();
			rs = stmt.executeQuery(query); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getEmployees();
	}
	
	public Employee getEmployeeById(String employeeID)
	{
		myCon = mCon.getMyConnection();
		Employee employee = new Employee();
		try
		{
			pstmt = myCon.prepareStatement("select * from Employees where employeeId = ?");
			pstmt.setString(1, employeeID);
			rs= pstmt.executeQuery();
			rs.next();
			String eId = rs.getString(1);
			String eName= rs.getString(2);
			String eAddress= rs.getString(3);
			String ePhone = rs.getString(4);
			int eSal = rs.getInt(5);
			float eTax = rs.getFloat(6);
		employee = new Employee(eId, eName, eAddress, ePhone, eSal, eTax);	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	
	public boolean insertEmployee(Employee employee)
	{
		boolean flag = false;
		myCon = mCon.getMyConnection();
		String query = "insert into employees values(?,?,?,?,?,?)";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeID());
			pstmt.setString(2, employee.getEmployeePhone());
			pstmt.setString(2, employee.getEmployeeAddress());
			pstmt.setString(4, employee.getEmployeePhone());
			pstmt.setInt(5, employee.getEmployeeSalary());
			pstmt.setDouble(6, employee.getProfTax());
			
			pstmt.execute();
			flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public boolean updateEmployee(Employee employee)
	{
		boolean flag = false;
		myCon = mCon.getMyConnection();
		String query = "update Employees set employeeAddress =? where employeeId = ?";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeAddress());
			pstmt.setString(2, employee.getEmployeeID());
			pstmt.execute();
			
			flag = true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
		
	}
	

}
