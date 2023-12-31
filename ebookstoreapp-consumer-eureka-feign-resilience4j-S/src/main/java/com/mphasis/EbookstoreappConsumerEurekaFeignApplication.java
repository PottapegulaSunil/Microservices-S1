package com.mphasis;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@EnableFeignClients
@SpringBootApplication
public class EbookstoreappConsumerEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappConsumerEurekaFeignApplication.class, args);
		System.out.println("Fieign Client Started");
	}
	
	@Bean
	public Sampler getSampler() {
		
		return Sampler.ALWAYS_SAMPLE;
	}

}