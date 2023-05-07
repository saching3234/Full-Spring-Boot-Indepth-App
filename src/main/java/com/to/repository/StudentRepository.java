package com.to.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.to.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{

	//defining the own method to fetch the data from db
    // find by the firstname
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByLastNameNotNull();
	
    public List<Student>	findByGuardianName(String guardianName);
    
    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);
    
    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId);
    
    //native query
    @Query(
    		value ="SELECT * FROM schooldb.tbl_student where email_address=?1" ,
    		nativeQuery=true    		
    		)
    Student getStudentByEmailAddressNativeQuery(String emailId);
    
    //NativeNamedParam query
    @Query(
    		value ="SELECT * FROM schooldb.tbl_student where email_address=:emailId" ,
    		nativeQuery=true    		
    		)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    
    //update method
    @Modifying
    @Transactional
    @Query(
    		value="update tbl_student set first_name=?1 where email_address=?2",
    		nativeQuery=true
    		)
    int updateStudentNameByEmailId(String firstName,String emailId);
    
    
    
    
    
}
