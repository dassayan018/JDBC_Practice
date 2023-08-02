package com.gl.jdbc.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.gl.jdbc.model.Employee;
import com.gl.jdbc.service.EmployeeService;

public class EmployeeDBManager {
	
	Connection mycon;
	Statement stmt;
	ResultSet rs;
	String reply = "Yes";
	Scanner scan  = new Scanner(System.in);
	int choice;
	EmployeeService eService = new EmployeeService();
	public void displayMenu() {
		
		while(reply.equals("Yes") || reply.equals("YES")) {
			System.out.println("--------------MAIN MENU----------------");
			System.out.println("1. View Employees.....");
			System.out.println("2. View Employee by ID.....");
			System.out.println("3. Insert Employee.....");
			System.out.println("4. Modify Employee.....");
			System.out.println("5. Delete Employee.....");
			System.out.println("6. Exit.....");
			System.out.println("Enter your choice");
			choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("Viewing Employees...");
				break;
			}
			case 2:
			{
				System.out.println("Viewing employees by ID");
				String employeeId;
				System.out.println("Enter the ID of the employee whose record you wish to see");
				employeeId = scan.next();
				Employee employee = eService.getEmployeeByID(employeeId);
				System.out.println(employee);
				break;
			}
			case 3:
			{
				System.out.println("Insert Employee");
				Employee employee = new Employee();
				String eId, eName, eAddress, ePhone;
				int eSal;
				float eTax;
				
				System.out.println("Enter Employee ID");
				eId = scan.next();
				
				System.out.println("Enter Employee Name");
				eName = scan.next();
				
				System.out.println("Enter Employee Address");
				eAddress = scan.next();
				
				System.out.println("Enter Employee Phone no");
				ePhone = scan.next();
				
				System.out.println("Enter Employee Salary");
				eSal = scan.nextInt();
				
				System.out.println("Enter professional tax");
				eTax = scan.nextFloat();
				
				employee = new Employee(eId, eName, eAddress, ePhone, eSal, eTax);
				
				if(eService.insertEmployeeSvc(employee))
				{
					System.out.println("Employee records inserted successfully");
				}
				else
				{
					System.out.println("Employee insertion failed");
				}
				break;
			}
			case 4:
			{
				System.out.println("Modify Employee");
				String empId, empAddr;
				System.out.println("Enter employee ID of the employee whose address you want to update");
				empId = scan.next();
				Employee employee = eService.getEmployeeByID(empId);
				System.out.println("The employee record for the given Id is");
				System.out.println(employee);
				System.out.println("Enter the new address for this employee");
				empAddr = scan.next();
				employee.setEmployeeAddress(empAddr);
				if(eService.updateEmployeeSvc(employee))
				{
					System.out.println("Updation successfull");
				}
				else
				{
					System.out.println("Error in updating");
				}
				
				break;
			}
			case 5:
			{
				System.out.println("Delete Employee by ID");
				break;
			}
			case 6:
			{
				System.out.println("Exiting Application");
				System.exit(0);
				break;
			}
			default:
			{
				System.out.println("Sorry the allowed options are from 1-6");
				break;	
			}
			}
			
			System.out.println("Do you wish to continue?? Yes or No");
			reply = scan.next();
		}
		System.out.println("Exited the application");
		
	}

}
