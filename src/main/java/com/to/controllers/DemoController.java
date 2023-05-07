package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.entity.Teacher;
import com.to.repository.TeacherRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	TeacherRepository teacherRepository;
	
	@PutMapping
	public Teacher updteTeacher(@RequestBody Teacher teacher) {
		
		Teacher teacher2=teacherRepository.findById(teacher.getTeacherId()).get();
		
		//updatting the fetched record
		teacher2.setFirstName(teacher.getFirstName());
		teacher2.setLastName(teacher.getLastName());
		//updating the record in the db
	    return	teacherRepository.save(teacher2);
		
	}
	
}
