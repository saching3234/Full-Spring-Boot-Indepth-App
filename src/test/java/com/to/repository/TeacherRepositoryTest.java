package com.to.repository;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.to.entity.Course;
import com.to.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository repository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDBA=Course.builder()
				.title("DBA")
				.credit(5)
				.build();
		Course courseJAVA=Course.builder()
				.title("JAVA")
				.credit(7)
				.build();
		
		
		Teacher teacher=Teacher.builder()
				.firstName("samiksha")
				.lastName("patil")
				//.courses(List.of(courseDBA,courseJAVA))
				.build();
		
		//now save the teacher
	  System.out.println("\n The course is added \n"+repository.save(teacher));
		
		
	}
	
}
