package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Employee;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:" + id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee existing = getEmployeeById(emp.getId());
		existing.setFirstName(emp.getFirstName());
		existing.setLastName(emp.getLastName());
		existing.setEmail(emp.getEmail());
		return repo.save(existing);
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
		
	}
	
	

}
