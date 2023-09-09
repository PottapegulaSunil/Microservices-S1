package com.payroll.empadmineurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EmpAdminEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAdminEurekaServerApplication.class, args);
		System.out.println("Eureka Server Started");

	}

}
