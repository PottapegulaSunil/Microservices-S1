package com.mphasis.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.mphasis.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@Service
public class BookService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Retry(name="book-service")
	@CircuitBreaker(name="book-service",fallbackMethod="FallBackMethodForGetBookById")
	public Book getBookById(Long id) {
		
		Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
		return book;
	
}
	public Book FallBackMethodForGetBookById(Long id,Throwable cause) {
		
		System.out.println("Exception Raised with Message:===>" + cause.getMessage());
		return new Book("History of michel King Cobra","Monish","Anyone.net","A12345c2576",100,2005);
	}
}