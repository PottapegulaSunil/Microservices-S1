package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EbookstoreappConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappConfigServerApplication.class, args);
		System.out.println("Server Started");
	}

}
