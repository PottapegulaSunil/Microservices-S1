package com.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients
@SpringBootApplication
public class EmpAdminConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAdminConsumerApplication.class, args);
		System.out.println("Fieign Client Started");
	}

	@Bean
	public Sampler alwaysSampler() {
	
	    return Sampler.ALWAYS_SAMPLE;
	}


}
