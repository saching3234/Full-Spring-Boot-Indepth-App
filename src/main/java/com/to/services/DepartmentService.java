package com.to.services;

import java.util.List;

import com.to.entity.Department;
import com.to.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

	public void deleDepartmentById(Long depId) throws DepartmentNotFoundException;

}
