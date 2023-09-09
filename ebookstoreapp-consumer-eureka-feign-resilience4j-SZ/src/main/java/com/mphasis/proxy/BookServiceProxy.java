package com.mphasis.proxy;

import java.util.ArrayList;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mphasis.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient(name = "book-service")
public interface BookServiceProxy {
	
	@Retry(name="book-service")
	@CircuitBreaker(
		    name = "book-service", fallbackMethod="fallbackMethodgetBookById")
	@GetMapping(value ="/books/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookById(@PathVariable("id") Long id);
	
	@Retry(name="book-service")
	@CircuitBreaker(
		    name = "book-service", fallbackMethod="fallbackMethodgetAllBooks")
	@GetMapping(value ="/books/all",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBooks();
	
	
	public default Book  fallbackMethodgetBookById(Long id,Throwable cause) {
		System.out.println("Exception raised with message ====>" + cause.getMessage());
		return new Book("History of michel King Cobra","Monish","Anyone.net","A12345c2576",100,2005);
	}
	
	
	public  default List<Book> fallbackMethodgetAllBooks(Throwable cause) {
		System.out.println("Exception raised with message ====>" + cause.getMessage());

		return new ArrayList<Book>();
	}
	

}
