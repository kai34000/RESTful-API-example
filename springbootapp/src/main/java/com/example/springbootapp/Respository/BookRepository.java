package com.example.springbootapp.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springbootapp.Model.Book;
import com.example.springbootapp.Model.User;
//import com.example.springbootapp.Model.wishlist;

public interface BookRepository extends JpaRepository<Book, String>{
	
//    List<SBook> findAll(String w);
    
//    List<Book> findAllByUserOrderByCreatedDateDesc(User user);
    
    @Query("FROM Book WHERE bookAuthor = ?1")
    List<Book> fetchAllBooksByAuthor(String author);

    @Query("FROM Book WHERE bookGenre = ?1")
    List<Book> fetchAllBooksByGenre(String genre);

    @Query("FROM Book order by bookCopiesSold desc")
    List<Book> fetchTopSoldBooks();

    @Query("FROM Book WHERE bookRating >= ?1")
    List<Book> fetchAllBooksByRating(int rating);
}
