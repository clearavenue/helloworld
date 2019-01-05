package com.clearavenue.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloworldApplication extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}

