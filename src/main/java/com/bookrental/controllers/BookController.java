package com.bookrental.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookrental.models.Book;
import com.bookrental.security.services.BookService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Book> getBookByID(@PathVariable("id") Long id) {
		Book book = bookService.findBookByID(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		boolean checkDuplicate = bookService.findDuplicateBook(book);
		
		if(checkDuplicate) {
			Book newBook = bookService.addBook(book);
			return new ResponseEntity<>(newBook, HttpStatus.CREATED);
		}
		else {
			// check for better way to send response
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book updateBook = bookService.updateBook(book);
		return new ResponseEntity<>(updateBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}