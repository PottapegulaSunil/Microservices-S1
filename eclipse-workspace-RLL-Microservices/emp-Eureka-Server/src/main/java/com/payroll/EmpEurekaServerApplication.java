package com.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EmpEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpEurekaServerApplication.class, args);
	}

}
