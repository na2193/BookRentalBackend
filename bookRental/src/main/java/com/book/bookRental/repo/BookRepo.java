package com.book.bookRental.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookRental.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	void deleteBookById(Long id);

	Optional<Book> findBookById(Long id);

}
