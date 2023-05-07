package com.to.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to.entity.Employee;
import com.to.error.EmployeeNotFoundException;
import com.to.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 
	 @Autowired
	 EmployeeRepository repository;
	
	@Override
	public Employee save(Employee employee) {
		
		return repository.save(employee);
	}

	@Override
	public Employee getEmployee(Integer eid) throws EmployeeNotFoundException {
		Optional<Employee> emp = repository.findById(eid);
		if(!emp.isPresent())
			throw new EmployeeNotFoundException("Sorry Emp with id "+eid+" Not found ");
		
		return emp.get();
	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> allEmps = repository.findAll();
		return allEmps;
	}

	@Override
	public Employee updateEmp(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> empFromDb = repository.findById(employee.getId());
		
		if(!empFromDb.isPresent())
			throw new EmployeeNotFoundException("Sorry Emp with id : "+employee.getId()+" Not Found ");
		
		//set the new value
		empFromDb.get().setAge(employee.getAge());
		empFromDb.get().setName(employee.getName());
		//save the value in the db and return the record
		return repository.save(empFromDb.get());
	}

	@Override
	public void deleteEmp(Integer eid) throws EmployeeNotFoundException {
		Optional<Employee> empFromDb = repository.findById(eid);
		
		if(!empFromDb.isPresent())
			throw new EmployeeNotFoundException("Sorry Emp with id : "+eid+" Not Found ");
		
		repository.delete(empFromDb.get());
	}

}
