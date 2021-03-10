package com.book.bookRental.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookRental.model.Book;
import com.book.bookRental.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable("id") Long id) {
		Book book = bookService.findBookByID(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book newBook = bookService.addBook(book);
		
		// add a check to make sure before adding the book, it already doesn't exist by id or maybe even isbn
		// also will need to modify the sql table to make sure all fields are not null and isbn is unique
		return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book updateBook = bookService.updateBook(book);
		return new ResponseEntity<>(updateBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
