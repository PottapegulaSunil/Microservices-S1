package com.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableEurekaClient
@SpringBootApplication
public class EmpLeaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpLeaveApplication.class, args);
		System.out.println("micro services has started");
	}
	
	@Bean
	public Sampler alwaysSampler() {
	
	    return Sampler.ALWAYS_SAMPLE;
	}

}
