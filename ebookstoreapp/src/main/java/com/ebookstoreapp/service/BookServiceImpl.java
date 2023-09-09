package com.ebookstoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ebookstoreapp.Repository.BookRepo;
import com.ebookstoreapp.entity.Book;

@Service (value = "bookService")
@Scope (value = "singleton")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier(value = "bookRepository")
	private BookRepo bookRepository;

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		
		return bookRepository.save(book);

	}

	@Override
	public List<Book> getAllBook() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteBookById(Long id) {
		
		bookRepository.deleteById(id);
		
	}

	@Override
	public List<Book> findByBookTitle(String bookTitle) {
		
		return bookRepository.findByBookTitle(bookTitle);
	}

	@Override
	public List<Book> findByBookPublisher(String bookPublisher) {
		
		return bookRepository.findByBookPublisher(bookPublisher);
	}

	@Override
	public List<Book> findByBookPublicationYear(String bookPublicationYear) {
		
		return bookRepository.findByBookPublicationYear(bookPublicationYear);
	}
}
