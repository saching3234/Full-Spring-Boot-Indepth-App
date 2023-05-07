package com.to.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//make this class embeddable so that in other class we can use it
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
//give the column name using the below method
@AttributeOverride(
		name = "email",
		column = @Column(name="guardian_email")
		)
@AttributeOverride(
		name = "name",
		column = @Column(name="guardian_name")
		)
@AttributeOverride(
		name = "mobile",
		column = @Column(name="guardian_mobile")
		)
@Builder
public class Guardian {
	
	private String name;
	private String email;
	private String mobile;

}
