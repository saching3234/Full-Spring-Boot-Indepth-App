package com.to.dto;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
	@NotBlank(message = "Username shouldn't be null")
	private String name;
	@Email(message = "Invalid email id")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message = "Enter the valid ten digit mobile no")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank(message = "Nationality is compulsory")
	private String nationality;
	
}
