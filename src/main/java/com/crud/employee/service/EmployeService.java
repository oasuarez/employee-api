package com.crud.employee.service;

import java.util.List;

import com.crud.employee.model.Employee;

public interface EmployeService {
	
	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeById(int employeeId);

	void deleteEmployee(int id);

	List<Employee> createEmployees(List<Employee> employees);

}
