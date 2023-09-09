package com.ebookstoreapp.Repository;

import org.springframework.stereotype.Repository;
import com.ebookstoreapp.entity.*;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository (value = "bookRepository")
@Scope(value = "singleton")
public interface BookRepo extends JpaRepository<Book,Long>{
	
	List<Book> findByBookTitle(String bookTitle);
	List<Book> findByBookPublisher(String bookPublisher);
	List<Book> findByBookPublicationYear(String bookPublicationYear);
	

}
