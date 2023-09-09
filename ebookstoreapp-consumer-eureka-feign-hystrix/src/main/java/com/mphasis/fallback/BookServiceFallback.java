package com.mphasis.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mphasis.entity.Book;
import com.mphasis.proxy.BookServiceProxy;

@Component
public class BookServiceFallback implements BookServiceProxy{

	@Override
	public Book getBookById(Long id) {
		return new Book("History of michel King Cobra","Monish","Anyone.net","A12345c2576",100,2005);
	}
	
	@Override
	public List<Book> getAllBooks() {
           
		return new ArrayList<Book>();
	}

}
