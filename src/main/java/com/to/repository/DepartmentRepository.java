package com.to.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.to.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
     public Department  findByDepartmentName(String departmentName);
     
     //IGORING THE CASE
     Department findByDepartmentNameIgnoreCase(String departmentName);
}
