package com.example.springbootapp.Model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="books")
public class Book {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN")
    public String isbn;

	
	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getYear_published() {
		return year_published;
	}

	public void setYear_published(Date year_published) {
		this.year_published = year_published;
	}


	

	public Book(String isbn, String book_name, String description, Double price, String author, String genre,
			String publisher, Date year_published) {
		super();
		this.isbn = isbn;
		this.book_name = book_name;
		this.description = description;
		this.price = price;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.year_published = year_published;
	}




	private String book_name;
    private String description;
    private Double price;
    private String author;
    private String genre;
    private String publisher;
    private Date year_published;

    public Book() {
    }


}