package com.to.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeNotFoundException extends Exception{
	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String msg) {
		super(msg);
		log.info("emp not found called......");
		
	}

}
