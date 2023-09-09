package com.ebookstoreapp1.service;

import java.util.List;


import com.ebookstoreapp1.entity.Book;

public interface BookService {
           
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public List<Book> getAllBook();
	public Book getBookById(Long id);
	public void deleteBookById(Long id);
	

	public List<Book> findByBookTitle(String bookTitle);
	public List<Book> findByBookPublisher(String bookPublisher);
	public List<Book> findByBookPublicationYear(String bookPublicationYear);
	
	
}
