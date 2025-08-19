package com.wipro.service;

import java.util.List;

import com.wipro.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	List<Employee> getAllEmployees();
	Employee updateEmployee(Employee emp);
	void deleteEmployee(Long id);

}
