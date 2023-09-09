package com.ebookstoreapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ebookstoreapp1.Repository.BookRepo;
import com.ebookstoreapp1.entity.Book;

//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Ebookstoreapp1Application implements CommandLineRunner{

	@Autowired
	@Qualifier("bookRepository")
	private BookRepo bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ebookstoreapp1Application.class, args);
		System.out.println("server started");
	
	
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		bookRepository.save(new Book("KingKong","Mike Conborge","Anyone.net","A12345c2581",100,2009));
		bookRepository.save(new Book("Kong","Rose","Anyone.net","A12345c2680",100,2005));
		bookRepository.save(new Book("History of michel","Mike Conborge","Anyone.net","A12345c2586",100,2005));
		bookRepository.save(new Book("JhonWick","Mike Conborge","Anyone.net","A12345c5580",100,2009));



		
		
	}
}
