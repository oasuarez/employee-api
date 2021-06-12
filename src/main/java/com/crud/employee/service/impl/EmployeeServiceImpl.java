package com.crud.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.employee.exception.EmployeeNotFoundException;
import com.crud.employee.model.Employee;
import com.crud.employee.repository.EmployeeRepository;
import com.crud.employee.service.EmployeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> createEmployees(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employeeUpdate = employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id :" + employee.getId()));

		employeeUpdate.setEmail(employee.getEmail());
		employeeUpdate.setName(employee.getName());
		employeeUpdate.setOffice(employee.getOffice());
		employeeUpdate.setPhone(employee.getPhone());
		employeeUpdate.setRole(employee.getRole());
		employeeRepository.save(employeeUpdate);
			
		return employeeUpdate;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id :" + employeeId));
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee employeeDelete = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id :" + employeeId));
		
		employeeRepository.delete(employeeDelete);
	}

}
