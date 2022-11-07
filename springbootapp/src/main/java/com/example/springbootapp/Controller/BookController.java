package com.example.springbootapp.Controller;

import com.example.springbootapp.Model.Book;
import com.example.springbootapp.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

//    /**
//     * this method is for retrieving book detail by ISBN
//     * @param bookISBN Book ISBN
//     * @return returns the Book Object
//     */
//    @GetMapping(value = "/{isbn}")
//    public Book getBookByBookISBN(@PathVariable(name = "isbn")String bookISBN) {
//        Optional<Book> bookOptional =  bookRepository.findById(bookISBN);
//        if(bookOptional.isPresent()) {
//            return bookOptional.get();
//        } else {
//            return null;
//        }
//    }

    /**
     * This method is for returning all the Books and books based on some conditions
     * @param author
     * @param genre
     * @param rating
     * @param x
     * @return List of the Book
     */
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(name = "author", required = false) String author, @RequestParam(name = "genre", required = false) String genre,
                                  @RequestParam(name = "rating", required = false)Integer rating, @RequestParam(name = "x", required = false) Integer x) {
        if(author!=null) {
            return bookRepository.fetchAllBooksByAuthor(author);
        }
        if(genre!=null) {
            return bookRepository.fetchAllBooksByGenre(genre);
        }
        if(rating!=null) {
            return bookRepository.fetchAllBooksByRating(rating);
        }
        if(x!=null) {
            List<Book> subList = bookRepository.findAll().subList(0,x);
            return subList;
        }
        return bookRepository.findAll();
    }


} // Ending BookController class