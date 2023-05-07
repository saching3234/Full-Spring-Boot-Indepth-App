package com.to.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.to.entity.Department;
import com.to.error.DepartmentNotFoundException;
import com.to.services.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/{departmentId}")
	public Department fetchDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
	    log.info("Inside the fetchDepartmentById" );
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@PostMapping("/")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@PutMapping("/{departmentId}")
	public Department updateDepartment(@PathVariable Long departmentId,@RequestBody Department department) {
	    return departmentService.updateDepartment(departmentId,department);	
	}
	
	//get department by name
	@GetMapping("/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable("id") Long depId) throws DepartmentNotFoundException {
		departmentService.deleDepartmentById(depId);
	}	
	
	//request paramas example
	 @GetMapping("/example")
	    public String exampleMethod(@RequestParam String name, @RequestParam int age) {
	        return "Hello, " + name + "! You are " + age + " years old.";
	    }
	
	
}
