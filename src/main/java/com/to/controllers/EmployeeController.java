package com.to.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.entity.Employee;
import com.to.error.EmployeeNotFoundException;
import com.to.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.save(employee);
	}
	
	@GetMapping("/{eid}")
	public Employee getEmployee(@PathVariable Integer eid) throws EmployeeNotFoundException {
		return service.getEmployee(eid);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return service.getAllEmps();
	}
	
	@PutMapping
	public Employee updateEmp(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return service.updateEmp(employee);
	}
	
	@DeleteMapping("/{eid}")
	public String deleteEmp(@PathVariable Integer eid) throws EmployeeNotFoundException {
		service.deleteEmp(eid);
		
		return "Employee id "+eid+" deleted successfully";
	}	
}
