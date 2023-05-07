package com.to.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.to.entity.Guardian;
import com.to.entity.Student;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//the below annotation is used to test the repo layer it will not modify the db
//@DataJpaTest
@Slf4j
class StudentRepositoryTest {
   
	@Autowired
	private StudentRepository studentRepository;
	
	//@Test
	public void saveStudent() {
		//make the student object
		Student student=Student.builder()
				.emailId("sachin@gmail.com")
				.firstName("sachin")
				.lastName("gawade")
				//.guardianName("nana")
				//.guardianEmail("nana@gmail.com")
				//.guardianMobile("999999999")
				.build();
		
		//now save the object in the db
		log.info(studentRepository.save(student).toString());
		
	}
	
	
	//@Test
	public void findByFirstName() {
		log.warn("\nfind by name method \n"+studentRepository.findByFirstName("shita"));
	}
	
	//@Test
	public void findByFirstNameContaining() {
		log.warn("\nfind by name method \n"+studentRepository.findByFirstNameContaining("sa"));
	}
	
	
	//@Test
	public void findByLastNameNotNull() {
		log.warn("\nfind by last name not null method \n"+studentRepository.findByLastNameNotNull());
	}

	//@Test
	public void findByGuardianName() {
		log.warn("\nfind by guardian name not null method \n"+studentRepository.findByGuardianName("sachin"));
	}
	
	
	
	
	//save student with the guardian details
	//@Test
	public void saveStuentWithGuardian() {
		//make the guardian object
		Guardian guardian=Guardian.builder()
				.name("sachin")
				.email("sachin@gmail.com")
				.mobile("7020498612")
				.build();
		Student student=Student.builder()
				.firstName("shital")
				.emailId("shital@gmail.com")
				.lastName("gawade")
				.guardian(guardian)
				.build();
		
		//now the the student object in the db using the repo
	 log.info("\n The new record added \n"+ studentRepository.save(student));
		
	}
	
	
	
	//@Test
	public void dislpayStudent() {
		log.info("\n The all student details are printed below \n "+studentRepository.findAll().toString());
	}
	
	
	//jpql 
	//@Test
	public void printStudentByEmailAddress() {
		Student student=studentRepository.getStudentByEmailAddress("sachin@gmail.com");
		log.info("\n get student by email id :"+student);
	}
	
	//jpql 
	//@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName=studentRepository.getStudentFirstNameByEmailAddress("shital@gmail.com");
		log.info("\n get student first Name by email id :"+firstName);
	}
	
	//native query 
	//@Test
	public void printStudentByEmailAddressNativeQuery() {
		Student student=studentRepository.getStudentByEmailAddressNativeQuery("sachin@gmail.com");
		log.info("\n get student by email id :"+student);
	}

	//native query named param
	//	@Test
		public void printStudentByEmailAddressNativeQueryNamedParam() {
			Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("shital@gmail.com");
			log.info("\n get student by email id named param :"+student);
		}
		
		//native query named param
		//@Test
		public void updateStudentByNativeQueryNamedParam() {
			int n=studentRepository.updateStudentNameByEmailId("sneha","shital@gmail.com");
			log.info("\n get student by email id named param :"+n);
		}
		
		
}
