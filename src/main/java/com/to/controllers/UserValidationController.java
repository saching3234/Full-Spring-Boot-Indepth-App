package com.to.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.dto.UserRequest;
import com.to.entity.User;
import com.to.error.DepartmentNotFoundException;
import com.to.error.UserNotFoundException;
import com.to.services.UserService;

@RestController
@RequestMapping("/users")
public class UserValidationController {

	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<User> getUserList(){
		return service.fetchUserList();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException {
		return service.fetchUserId(id);
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}

}
