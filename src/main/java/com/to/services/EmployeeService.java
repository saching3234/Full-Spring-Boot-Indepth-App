package com.to.services;

import java.util.List;

import com.to.entity.Employee;
import com.to.error.EmployeeNotFoundException;

public interface EmployeeService {

	Employee save(Employee employee);

	Employee getEmployee(Integer eid) throws EmployeeNotFoundException;

	List<Employee> getAllEmps();

	Employee updateEmp(Employee employee) throws EmployeeNotFoundException;

	void deleteEmp(Integer eid) throws EmployeeNotFoundException;

}
