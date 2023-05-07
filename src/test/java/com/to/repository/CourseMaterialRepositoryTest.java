package com.to.repository;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.to.entity.Course;
import com.to.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void SaveCourseMaterial() {
		//create the object of the course
		Course course=Course.builder()
				.credit(10)
				.title("DSA")
				.build();
		//create the object of the course Material
		CourseMaterial courseMaterial=CourseMaterial.builder()
				.url("google.com")
			//	.course(course)
				.build();
		
		//save the coursematerial in the db
		repository.save(courseMaterial);		
	}
	
	@Test
	public void displayAllCourseMaterials() {
	  List<CourseMaterial> courseMaterial=repository.findAll();
		System.out.println(courseMaterial);
	}
	
	
}
