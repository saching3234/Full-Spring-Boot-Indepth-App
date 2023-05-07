package com.to.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import com.to.entity.ErrorMessage;

@RestControllerAdvice
public class RestResponseEntityExceptionHander
     
{
	//department not found exception
	@ExceptionHandler(DepartmentNotFoundException.class)
     public  ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,WebRequest request) {
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);          	 
     }
	
	//user not found exception
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> userNotFoundException(UserNotFoundException ex){
		Map<String, String> map=new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}
	
	
	
	//employee not found exception handler class
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> empNotFoundException(EmployeeNotFoundException ex){
		Map<String, String> map=new HashMap();
		map.put("errorMessage", ex.getMessage());
		return map;
	}	
	
	//user validation 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e->{
			map.put(e.getField(),e.getDefaultMessage());			
		});
		
		return map;
	}
	
	
}
