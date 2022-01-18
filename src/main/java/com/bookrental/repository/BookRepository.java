package com.bookrental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookrental.models.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

	void deleteBookById(Long id);

	Optional<Book> findBookById(Long id);
	
	Book findByisbn(String isbn);

	//Book findBybookNameAndauthorLastNameAndauthorFirstName(String bookName, String authorLastName, String authorFirstName);
	
}
