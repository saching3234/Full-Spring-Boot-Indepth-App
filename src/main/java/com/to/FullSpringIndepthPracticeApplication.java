package com.to;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.to.beans.MyBean;

@SpringBootApplication
public class FullSpringIndepthPracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(FullSpringIndepthPracticeApplication.class, args);

		/*
		 * MyBean bean = run.getBean(MyBean.class);
		 * bean.setBeanName("first bean object"); bean.setNameString("Sachin GAwade");
		 * System.out.println(bean); MyBean bean2 = run.getBean(MyBean.class); //
		 * bean2.setBeanName("second bean object"); System.out.println(bean2);
		 * System.out.println(bean == bean2);
		 */

	}

	// manually creating the object of bean and giving it to the spring container

	
	  @Bean
	  
	  @Scope(scopeName = "prototype") public MyBean getBean() 
	  { 
		  return new MyBean(); 
	  }
	 

}
