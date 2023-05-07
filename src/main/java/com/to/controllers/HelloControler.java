package com.to.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

	@GetMapping("/")
	public String helloWrold() {
		return "Hello from the spring boot world";
	}
}
