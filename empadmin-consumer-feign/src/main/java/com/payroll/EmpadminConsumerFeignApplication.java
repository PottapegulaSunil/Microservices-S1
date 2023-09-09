package com.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmpadminConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpadminConsumerFeignApplication.class, args);
		System.out.println("Fieign Client Started");
	}

}
