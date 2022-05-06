package com.cognixia.jump;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.model.Employee;
import com.cognixia.jump.util.EmployeeManager;
import com.cognixia.jump.util.EmployeeManagerFile;
import com.cognixia.jump.util.EmployeeManagerInMemory;

// CRUD Operations - Create Read Update Delete

// Create an EMS that allows us to:
// 1. view all employees
// 2. view particular employee
// 3. create employees
// 4. delete employees
// 5. update employees
// 6. view all employees in a singular department (ex: all employees in HR)
// Expect: Console Based Menu


/*
 * Assignment:
 * - finish the EmployeeManagerInMemory (implement rest of methods)
 * - set up the create employee section of the menu
 * - send it over through slack (files, zip, or github)
 * */

public class Main {

	private static EmployeeManager manager;
	public static Scanner sc;
	public static int id;
	public String name;
	public String department;
	public int salary;
	public String email;


	public static void main(String[] args) {

		manager = new EmployeeManagerInMemory();
		//manager = new EmployeeManagerFile();
		
		sc = new Scanner(System.in);
		

		System.out.println("WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM (EMS)\n");

		mainMenu();

	}

	public static void mainMenu() {

		while (true) {

			try {
				System.out.println("\nPlease enter one of the following options :" 
									+ "\n1.) View Employees"
									+ "\n2.) Select Employee By Id" 
									+ "\n3.) Create Employee" 
									+ "\n4.) Update Employee"
									+ "\n5.) Delete Employee" 
									+ "\n6.) Exit");
				
				System.out.println("Enter your choice : ");
				int option = sc.nextInt();
				sc.nextLine(); // getting rid of new line character

				switch (option) {
				case 1:
					viewEmployees();
					break;
				case 2:
					
					break;
				case 3:
					createEmployee();
					break;
				case 4:
					updateEmployee();
					break;
				case 5:
					break;
				case 6:
					break;

				default:
					System.out.println("\nPlease enter a number between 1 and 6");
					break;
				}

				if (option == 6) {
					break;
				}

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nPlease enter a number between 1 and 6");
			}

		}

	}
	
	public static void viewEmployees() {
		
		
		while(true) {
			
			try {
			
				System.out.println("Select one of the follow:" + 
							"\n1. Select all employees" +
						    "\n2. Select employees by department" +
							"\n3. Exit to return to main menu");
				
				int option = sc.nextInt();
				sc.nextLine();
				
				switch (option) {
				case 1:
					viewAllEmployees();
					break;
				case 2:
					
					break;
				case 3:
					break;
				default:
					System.out.println("Enter number between 1 and 3");
					break;
				}
				
				if(option == 3) {
					break;
				}
				
				
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Enter number between 1 and 3");
			}
		}
		
	}
	
	public static void viewAllEmployees() {
		List<Employee> employees = manager.getAllEmployees();
		
		
		if(employees.isEmpty()) {
			System.out.println("No employees currently in EMS");
		}
		else {
			for(Employee e : employees) {
				System.out.println(e);
			}
		}
		
		
	}
	public static void createEmployee() {
		
	
while(true) {
			
			try {
			
				System.out.println("Select one of the following:" + 
							"\n1. Select Hourly employee" +
						    "\n2. Select contract employee" +
						    "\n3. Select salary employee" +
							"\n4. Exit to return to");
				

				int option = sc.nextInt();
				sc.nextLine();
				
				switch (option) {
				case 1:
					createHourlyEmployee();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("Enter number between 1 and 3");
					break;
				}
				
				if(option == 4) {
					break;
				}
				
				
			}finally {
			    // ... cleanup that will execute whether or not an error occurred ...
			}
	
			}
	}

	public static void createHourlyEmployee() {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter the following details to ADD list:\n");
		//System.out.println("Enter ID :");
		//id = sc.nextInt();
		System.out.print("\nEnter the name: ");
		String name = input.next();
		System.out.print("\nEnter the department: ");
		String department = input.next();
		System.out.print("\nEnter the salary: ");
		int salary = sc.nextInt();
        System.out.print("\nEnter the email: ");
		String email = input.next();
		
        manager.createEmployee(new Employee (0, name,department, salary, email));
        System.out.print("Employee was created successfully");
        
		//Employee.add(new Employee(id, name, department, salary, email));
		
		//EmployeeManagerInMemory m = new EmployeeManagerInMemory();
		//m.createEmployee(null);
		
	   // System.out.println("Employee " + name + " " +department + " Created succesfully");
		// TODO Auto-generated method stub
		
	}

public static void updateEmployee() {
		

	
	
				System.out.println("\nEnter the Employee ID to EDIT the details");
				id = sc.nextInt();
				int j=0;
				for(Employee e : manager.getAllEmployees())
				{
					if(id == e.id)
					{	
						j++;
					do{
						int ch1 =0;
						System.out.println("\nEDIT Employee Details :\n" +
											"1). Employee ID\n" +
											"2). Name\n" +
											"3). Salary\n" +
											"4). department\n" +
											"5). email\n" +
											"6). GO BACK\n");
						System.out.println("Enter your choice : ");
						ch1 = sc.nextInt();
						switch(ch1)
						{
						case 1: System.out.println("\nEnter new Employee ID:");
								e.id =sc.nextInt();
								System.out.println(e+"\n");
								break;
						
						case 2: System.out.println("Enter new Employee Name:");
								e.name =sc.nextLine();
								System.out.println(e+"\n");
								break;
								
						case 3: System.out.println("Enter new Employee Salary:");
								e.salary =sc.nextInt();
								System.out.println(e+"\n");
								break;
								
						case 4: System.out.println("Enter new Employee department :");
								e.department =sc.next();
								System.out.println(e+"\n");
								break;
								
						case 5: System.out.println("Enter new Employee Email :");
								e.email =sc.next();
								System.out.println(e+"\n");
								break;
								
						case 6: j++;
								break;
								
						default : System.out.println("\nEnter a correct choice from the List :");
									break;
						
						}
						}
					while(j==1);
					}
				}
				if(j == 0)
				{
					System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
				}
			
			//	break;
				
				
				
				
				
	
}}



