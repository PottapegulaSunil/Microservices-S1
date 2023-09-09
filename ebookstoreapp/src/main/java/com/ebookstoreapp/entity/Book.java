package com.ebookstoreapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookISBN;
    private int bookNumberOfPages;
    private int bookPublicationYear;

    // Constructors (you can have multiple constructors if needed)
    public Book() {
    }

    public Book(String bookTitle, String bookAuthor, String bookPublisher, String bookISBN,
                int bookNumberOfPages, int bookPublicationYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookISBN = bookISBN;
        this.bookNumberOfPages = bookNumberOfPages;
        this.bookPublicationYear = bookPublicationYear;
    }

    // Getters and setters for all attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public int getBookNumberOfPages() {
        return bookNumberOfPages;
    }

    public void setBookNumberOfPages(int bookNumberOfPages) {
        this.bookNumberOfPages = bookNumberOfPages;
    }

    public int getBookPublicationYear() {
        return bookPublicationYear;
    }

    public void setBookPublicationYear(int bookPublicationYear) {
        this.bookPublicationYear = bookPublicationYear;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", bookNumberOfPages=" + bookNumberOfPages +
                ", bookPublicationYear=" + bookPublicationYear +
                '}';
    }


}

