package com.payroll;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmpAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAdminApplication.class, args);
		System.out.println("Server Started for microservice");
	}
	

}
