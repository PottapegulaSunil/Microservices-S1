package com.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableEurekaClient
@SpringBootApplication
public class EmpAdminappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAdminappApplication.class, args);
		System.out.println("microservice server started");
	}
	
	@Bean
	public Sampler alwaysSampler() {
	
	    return Sampler.ALWAYS_SAMPLE;
	}

}
