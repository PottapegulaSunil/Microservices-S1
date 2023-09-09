package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.entity.Book;
import com.mphasis.service.BookService;

import io.micrometer.core.annotation.Timed;

@RestController
@Scope("request")
public class BookClientController {
	
	@Autowired
	private BookService bookService;
	
	@Timed(value = "getBookById.time", description = "Time taken to return the book")
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		
		return bookService.getBookById(id);
	}
}

