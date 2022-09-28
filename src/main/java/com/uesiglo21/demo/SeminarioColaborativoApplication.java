package com.uesiglo21.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SeminarioColaborativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarioColaborativoApplication.class, args);
	}

}
