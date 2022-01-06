package com.bookrental.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookrental.exception.NotFoundException;
import com.bookrental.models.Book;
import com.bookrental.repository.BookRepository;



@Service
public class BookService {
	private final BookRepository bookRepo;
	
	@Autowired
	public BookService(BookRepository bookRepo) {
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
				.orElseThrow(() -> new NotFoundException("Book by id " + id + " was not found"));
	}
	
	@Transactional
	public void deleteBook(Long id) {
		bookRepo.deleteBookById(id); 
	}
}