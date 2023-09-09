package com.ebookstoreapp1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ebookstoreapp1.entity.Book;
import com.ebookstoreapp1.service.BookService;

@RestController
@Scope(value ="request")
public class BookController {
	
	@Autowired
	@Qualifier(value = "bookService")
	private BookService bookService;
	
	
	@PostMapping(value ="/books" ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
		
	}
	
	
	@PutMapping(value ="/books" ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
		
	}


	@DeleteMapping(value ="/books/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		
		bookService.deleteBookById(id);
	}
	
	@GetMapping(value ="/books/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookById(@PathVariable("id") Long id) {
		
		 return bookService.getBookById(id);
	}
	
	@GetMapping(value ="/books/all",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBook() {
		
		return bookService.getAllBook();
	}
	
	@GetMapping(value ="/books/bookTitle/{bookTitle}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBookByBookTite(@PathVariable("bookTitle") String bookTitle) {
		
		return bookService.findByBookTitle(bookTitle);
	}
	
	@GetMapping(value ="/books/bookPublisher/{bookPublisher}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBookByBookPublisher(@PathVariable("bookPublisher") String bookPublisher) {
		
		return bookService.findByBookPublisher(bookPublisher);
	}
	
	@GetMapping(value ="/books/bookPublicationYear/{bookPublicationYear}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBookByBookPublicationYear(@PathVariable("bookPublicationYear") String bookPublicationYear) {
		
		return bookService.findByBookPublicationYear(bookPublicationYear);
	}
}

