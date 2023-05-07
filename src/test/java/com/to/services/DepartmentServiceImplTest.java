package com.to.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.to.entity.Department;
import com.to.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceImplTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@MockBean
	private DepartmentRepository mockDepartmentRepository;	
	
	@BeforeEach
	void setUp() {
		Department department=
				Department.builder()
				.departmentName("IT")
				.departmentAddress("PUNE")
				.departmentCode("IT-01")
				.departmentId(1l)
				.build();
		
			Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
			.thenReturn(department);
	}
	
	@Test
	@DisplayName("Get data based on valid department name")
	//with the @Disabled annotation you can disable the test case
	void whenValidDepartmentName_thenDepartmentShouldFound() {
		String deptName="IT";
		Department found=departmentRepository.findByDepartmentNameIgnoreCase("IT");
		assertEquals(deptName, found.getDepartmentName());
	}

}
