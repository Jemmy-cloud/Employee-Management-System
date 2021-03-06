package com.cognixia.jump.util;

import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.exceptions.EmployeeNotFoundException;
import com.cognixia.jump.model.Employee;

public class EmployeeManagerInMemory implements EmployeeManager {
	

	private static int idCounter = 1;
	public static List<Employee> employeeList = new ArrayList<Employee>();
	//ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static {
		employeeList.add(new Employee(idCounter++, "Tom", "HR", 50000, "tom@email.com"));
		employeeList.add(new Employee(idCounter++, "Mary", "HR", 50000, "mary@email.com"));
		employeeList.add(new Employee(idCounter++, "Anna", "IT", 50000, "anna@email.com"));
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
		
		for(Employee e : employeeList) {
			if(e.getId() == id) {
				return e;
			}
		}
		
		throw new EmployeeNotFoundException(id);
	}

	@Override
	public boolean createEmployee(Employee empl) {
		
		// reset id to be unique using the counter
		empl.setId(idCounter++);
		
		employeeList.add(empl);
		
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		for(Employee e : employeeList) {
			if(e.getId() == id) {
				employeeList.remove(e);
			}
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee empl) {
		int j=0;
		for(Employee e : employeeList) {
			if(e.getName() == toString()) {
				j++;
			}
			
			}
		return false;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String dept) {
		List<Employee> samedept = new ArrayList<Employee>();
		
		for(Employee e : employeeList) {
			if(e.getDepartment().equals(dept)) {
				
				samedept.add(e);
			}
		}
		return samedept;
		
	}
	
	@Override
	public List<Employee> updateEmployeesByDepartment(String dept) {
		int j=0;
		for(Employee e : employeeList) {
			if(e.getDepartment() == dept) {
				j++;
			}
		}
		return null;
	}
	
	@Override
	public List<Employee> deleteEmployeesByDepartment(String dept) {
		for(Employee e : employeeList) {
			if(e.getDepartment() == dept) {
				employeeList.remove(e);
			}
		}
		return null;
	}

}
