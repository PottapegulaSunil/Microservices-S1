package com.mphasis.constoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger log = LoggerFactory.getLogger(BookClientController.class);
	
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		
		log.debug("In getBookById with id:" +  id);
		Book book=bookServiceProxy.getBookById(id);
		log.debug("In return with the value :" + book);
		return book;
	}
	
	@GetMapping("/get-books")
	public List<Book> getAllBooks() {
		
		
		List<Book> book=bookServiceProxy.getAllBooks();
		log.debug("In return with the value :" + book);
		return book;
	}

}
