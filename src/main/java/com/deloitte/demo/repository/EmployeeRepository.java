package com.deloitte.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.deloitte.demo.model.Employee;

public class EmployeeRepository {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EnployeePU");
	
	 public Employee addEmployee(Employee employee) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        
	        try {
	            transaction.begin();
	            entityManager.persist(employee);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	        
	        return employee;
	    }

	    public Employee updateEmployee(Employee employee) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        
	        try {
	            transaction.begin();
	            entityManager.merge(employee); 
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	        
	        return employee;
	    }

	    public void deleteEmployee(int employeeId) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        
	        try {
	            transaction.begin();
	            Employee employee = entityManager.find(Employee.class, employeeId);
	            if (employee != null) {
	                entityManager.remove(employee);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    public List<Employee> getAllEmployees() {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
	        entityManager.close();
	        return employees;
	    }

	    public Employee getEmployeeById(int employeeId) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        Employee employee = entityManager.find(Employee.class, employeeId);
	        entityManager.close();
	        return employee;
	    }
}
