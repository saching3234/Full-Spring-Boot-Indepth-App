package com.to.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table annotation to give a different name in db
@Table(name="tbl_student",
       uniqueConstraints = @UniqueConstraint(
    		   name="emailid_unique",
    		   columnNames = "email_address"
    		   )	
		)
public class Student {
	@Id
	//defining the sequence 
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	//give the sequence to generated value
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	private Long studentId;
	private String firstName;
	private String lastName;
	//giving the different name in db for column
	@Column(name = "email_address",
			nullable = false
			)
	private String emailId;
	
	@Embedded
	private Guardian guardian;

	@Override
	public String toString() {
		return "\n Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", guardian=" + guardian + "]";
	}	
	
	
	
	
	
}
