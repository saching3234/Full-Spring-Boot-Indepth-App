package com.to.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to.entity.Department;
import com.to.error.DepartmentNotFoundException;
import com.to.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
   
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
	
		Optional<Department> department= departmentRepository.findById(departmentId);
		//if department not present in the db
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department not available");
		
		//if present then return the department
		 return department.get();
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
	     //find the department from the db first
		Department depDB=departmentRepository.findById(departmentId).get();
	   
	  //check the user send data fields not null and blank and update
		if(Objects.nonNull(department.getDepartmentName()) &&
			!"".equalsIgnoreCase(department.getDepartmentName())){
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) &&
				!"".equalsIgnoreCase(department.getDepartmentAddress())){
				depDB.setDepartmentAddress(department.getDepartmentAddress());
			}
		
		if(Objects.nonNull(department.getDepartmentCode()) &&
				!"".equalsIgnoreCase(department.getDepartmentCode())){
				depDB.setDepartmentCode(department.getDepartmentCode());
			}
		
		//update the department in the db
	    return	departmentRepository.save(depDB);
	
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {		
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public void deleDepartmentById(Long depId) throws DepartmentNotFoundException {
		Optional<Department> department= departmentRepository.findById(depId);
		//if department not present in the db
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department not available");
		
		//if present then return the department
		departmentRepository.delete(department.get());
		
	}

}
