package com.mphasis;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@SpringBootApplication
public class EbookstoreappConsumerEurekaRibbionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappConsumerEurekaRibbionApplication.class, args);
		System.out.println("Server Started");
	}
	
	@Bean
	public Sampler getSmpler() {
		
		//return Sampler.create(0.5f);
		return Sampler.ALWAYS_SAMPLE;
		
	}

}
