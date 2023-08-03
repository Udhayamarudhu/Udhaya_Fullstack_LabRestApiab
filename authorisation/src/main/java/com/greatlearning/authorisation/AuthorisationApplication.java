package com.greatlearning.authorisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"com.greatlearning.authorisation.controller"})
public class AuthorisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorisationApplication.class, args);
	}

}
