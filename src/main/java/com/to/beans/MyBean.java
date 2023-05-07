package com.to.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Scope(scopeName = "prototype")
@Data
public class MyBean implements BeanNameAware{
	
	String nameString;
	String beanName;

	@Override
	public void setBeanName(String name) {
		System.out.println("Set bean name is called");
		beanName=name;		
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("The post construct method is called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("pre destroy method of bean lifecycle is called");
	}

}
