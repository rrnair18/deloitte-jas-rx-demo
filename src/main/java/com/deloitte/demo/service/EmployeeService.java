package com.deloitte.demo.service;

import java.util.Arrays;
import java.util.List;

import com.deloitte.demo.model.Department;
import com.deloitte.demo.model.Employee;

public class EmployeeService {
    
	Department financeDept = new Department(1, "Finance", "Bangalore");
    Department hrDept = new Department(2, "HR", "Mumbai");
	
    List<Employee> empList = Arrays.asList(
        new Employee(1, "Sonu", 90.25, financeDept),
        new Employee(2, "Monu", 95.75, financeDept),
        new Employee(3, "Tonu", 92.25, hrDept)
    );

    public List<Employee> getAllEmployees() {
        empList.forEach(System.out::println);
        return empList;
    }
    
    Department itDept = new Department(3, "IT", "Hyderabad");
    Employee newEmployee = new Employee(4, "Ravi", 100.00, itDept);

}
