package com.learning.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class EmployeeSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApiApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
