package com.bookrental.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false)
	private String bookName;
	@Column(nullable = false)
	private String authorLastName;
	@Column(nullable = false)
	private String authorFirstName;
	@Column(nullable = false)
	private String isbn;
	@Column(nullable = false)
	private String genre;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int numInStock;
	private String imagePath;

	public Book() {}

	public Book(Long id, String bookName, String authorLastName, String authorFirstName, String isbn, String genre,
			String description, int numInStock, String imagePath) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorLastName = authorLastName;
		this.authorFirstName = authorFirstName;
		this.isbn = isbn;
		this.genre = genre;
		this.description = description;
		this.numInStock = numInStock;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumInStock() {
		return numInStock;
	}
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorLastName=" + authorLastName + ", authorFirstName="
				+ authorFirstName + ", isbn=" + isbn + ", genre=" + genre + ", description=" + description
				+ ", numInStock=" + numInStock + ", imagePath=" + imagePath + "]";
	}
}