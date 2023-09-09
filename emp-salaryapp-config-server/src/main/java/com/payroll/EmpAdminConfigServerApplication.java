package com.payroll;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EmpAdminConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAdminConfigServerApplication.class, args);
		System.out.println("Config Server Started");
	}

}
