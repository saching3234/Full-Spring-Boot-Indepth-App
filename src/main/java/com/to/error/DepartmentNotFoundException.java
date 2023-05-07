package com.to.error;

public class DepartmentNotFoundException extends Exception{ 
	//default constructor
	  public DepartmentNotFoundException() {
		super();
	}
	  
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	  
}
