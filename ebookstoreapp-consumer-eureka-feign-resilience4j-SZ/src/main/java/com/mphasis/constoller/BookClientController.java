package com.mphasis.constoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.entity.Book;
import com.mphasis.proxy.BookServiceProxy;

@RestController
@Scope("request")
public class BookClientController {
	
	@Autowired
	private BookServiceProxy bookServiceProxy;
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		
		Book book=bookServiceProxy.getBookById(id);
		return book;
	}
	
	@GetMapping("/get-books")
	public List<Book> getAllBooks() {
		
		List<Book> book=bookServiceProxy.getAllBooks();
		return book;
	}

}
