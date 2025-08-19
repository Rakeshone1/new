package com.wipro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;
import com.wipro.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		
		Employee saved = service.createEmployee(emp);
		return ResponseEntity.status(201).body(saved);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee emp = service.getEmployeeById(id);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		emp.setId(id);
		Employee updated = service.updateEmployee(emp);
		return ResponseEntity.ok(updated);
	}
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		Map<String, Boolean> resp = new HashMap<>();
		resp.put("deleted", Boolean.TRUE);
		return resp;
	}

}
