package com.crud.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
