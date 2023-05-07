package com.to.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
			)
	private Long courseId;
	private String title;
	private Integer credit;
	
	@OneToOne(
			//tell that mapping is already done by course material class course object
			mappedBy = "course"
			)	
	private CourseMaterial courseMaterial;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId"
			)	
	private Teacher teacher;	
	//many to many 
	@ManyToMany(
			cascade = CascadeType.ALL
			)
	@JoinTable(
			//give the third tabl name
			name = "student_course_map",
			//give the joining column name
			joinColumns=@JoinColumn(
					//db column name
					name = "course_id",
					//class member name
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn(
					name="student_id",
					referencedColumnName = "studentId"					
					)	
			)
	
    private	List<Student> students;
	
	
	//method for adding the student
	public void addStudents(Student student) {
		if(students==null)
			students=new ArrayList<Student>();
		
		students.add(student);
	}
	
}
