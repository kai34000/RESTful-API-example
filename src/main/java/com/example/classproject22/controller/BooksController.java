package com.example.classproject22.controller;

import com.example.classproject22.exception.ResourceNotFoundException;
import com.example.classproject22.model.Books;
import com.example.classproject22.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class BooksController {

    @Autowired
    private BookRepo bookRepo;

    // get all books
    @GetMapping(path = "books")
    public List<Books> getAllBooks(){ return this.bookRepo.findAll();}

    // get book by isbn
    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<Books> getBookByISBN(@PathVariable(value = "isbn") Long isbn)
        throws ResourceNotFoundException {
        Books books = bookRepo.findById(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found by this ISBN: " + isbn));
        return ResponseEntity.ok().body(books);
    }

    @GetMapping(path = "/books/search")
    public List<Books> searchBooks( @RequestParam(name = "genre", required = false) String genre) {
        if (genre != null) {
            return this.bookRepo.findBooksByGenre(genre);
        } else {
            return new ArrayList<>();
        }
    }


    // save book
    @PostMapping(path = "books")
    public Books createBook(@RequestBody Books books) {
        return this.bookRepo.save(books);
    }



}
