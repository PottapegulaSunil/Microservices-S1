package com.mphasis;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;





@SpringBootApplication
public class EbookstoreappConsumerEurekaRibbionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappConsumerEurekaRibbionApplication.class, args);
		System.out.println("Server Started");
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		
		return new TimedAspect(registry); 
		
	}

}
