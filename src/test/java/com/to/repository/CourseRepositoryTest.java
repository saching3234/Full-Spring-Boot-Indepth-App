package com.to.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.to.entity.Course;
import com.to.entity.Student;
import com.to.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	CourseRepository repository;
	
	//@Test
	public void displayCourses() {
		List<Course> course=repository.findAll();
		System.out.println(course);
	}
	
	//@Test
	public void saveCourseWithTeacher() {
		Teacher teacher=Teacher.builder()
				.firstName("sachin")
				.lastName("gawade")				
				.build();
		
		Course course=Course.builder()
				.title("Paython")
				.credit(9)
				.teacher(teacher)
				.build();
		repository.save(course);
	}

	//many to many saving the data in the db
	//@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher=Teacher.builder()
				.firstName("shital")
				.lastName("gawade")
				.build();
		
		Student student=Student.builder()
				.firstName("sneha")
				.lastName("atole")
				.emailId("sneha@gmail.com")
				.build();
		
		Course course=Course.builder()
				.title("AI")
				.credit(12)
				.teacher(teacher)
				.build();
		
		course.addStudents(student);		
		//save in the db now
		repository.save(course);
	}
	
	
  //paging and sorting
	//@Test
	//@Transactional
	public void findAllPagination() {
	
		 Pageable firstPagewithThreeRecords= PageRequest.of(0, 2);
		 Pageable secondPagewithTwoRecords= PageRequest.of(1, 2);
	
		 List<Course> courses=
				 repository.findAll(firstPagewithThreeRecords).getContent();		 
		 System.out.println("\ncourses :\n "+courses);
		 
		 
		 List<Course> courses2=
				 repository.findAll(secondPagewithTwoRecords).getContent();		 
		 System.out.println("\nsecond page request :\n "+courses2);
		 
		 //finding the total elements and total pages
		 long totalElements=repository.findAll(firstPagewithThreeRecords).getTotalElements();
		 long totalPages=repository.findAll(firstPagewithThreeRecords).getTotalPages();
	
		 System.out.println("The total elemenents are with three records : "+totalElements);
		 System.out.println("The total pages are with three records : "+totalPages);
	}
	
	
	//pagination with the sorting
	@Test
	@Transactional
	public void findAllSorting() {
		
		Pageable sortByTitle=PageRequest.of(0, 2,Sort.by("title"));
		Pageable sortByCredit=PageRequest.of(0, 2,Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc=PageRequest.of(0, 2,Sort.by("title").descending().and(Sort.by("credit")));
		
		 List<Course> courses=
				 repository.findAll(sortByTitleAndCreditDesc).getContent();		 
		 System.out.println("\nsortByTitleAndCreditDesc :\n "+courses);		
	}
	
	
	//@Test
	//@Transactional
	public void printfindByTitleContainig() {
		Pageable firstPageTenRecords=PageRequest.of(0, 10);
		
		List<Course> courses=repository.findByTitleContaining("D", firstPageTenRecords).getContent();
		System.out.println("\nfindByTitleContaining \n"+courses);
	}
	
}
