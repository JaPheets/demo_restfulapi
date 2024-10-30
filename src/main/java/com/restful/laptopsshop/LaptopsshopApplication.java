package com.restful.laptopsshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class LaptopsshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopsshopApplication.class, args);
	}

}
