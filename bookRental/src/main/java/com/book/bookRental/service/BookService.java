package com.book.bookRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.bookRental.exception.BookNotFoundException;
import com.book.bookRental.model.Book;
import com.book.bookRental.repo.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	
	@Autowired
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBookByID(Long id) {
		return bookRepo.findBookById(id)
				.orElseThrow(() -> new BookNotFoundException("Book by id " + id + " was not found"));
	}
	
	@Transactional
	public void deleteBook(Long id) {
		bookRepo.deleteBookById(id); 
	}
}
