package com.deloitte.demo.service;

import java.util.List;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.repository.EmployeeRepository;

public class EmployeeService {

	private EmployeeRepository employeeRepository = new EmployeeRepository();

	public Employee addEmployee(Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.getEmployeeById(employee.getId());
		if (existingEmployee != null) {
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setSalary(employee.getSalary());
//			existingEmployee.setDepartment(employee.getDepartment());
			return employeeRepository.updateEmployee(existingEmployee);
		}
		return null;
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteEmployee(id);
	}

	public List<Employee> getAllEmployees() {
		System.out.println("All employees");
		return employeeRepository.getAllEmployees();
	}

	public Employee getEmployeeById(int employeeId) {
		Employee employee = employeeRepository.getEmployeeById(employeeId);
		System.out.println("Fetched Employee: " + employee);
		return employee;
	}

}
