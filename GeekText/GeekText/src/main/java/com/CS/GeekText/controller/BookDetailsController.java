package com.CS.GeekText.controller;

import com.CS.GeekText.exceptions.ResourceNotFoundException;
import com.CS.GeekText.model.Authors;
import com.CS.GeekText.model.Books;
import com.CS.GeekText.repository.AuthorRepository;
import com.CS.GeekText.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BookDetailsController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorsRepository;

    @GetMapping("books")
    public List<Books> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("books/{isbn}")
    public ResponseEntity<Books> getBookByIsbn(@PathVariable(value = "isbn") Long bookIsbn)
            throws ResourceNotFoundException {
        Books book = bookRepository.findById(bookIsbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this ISBN :: " + bookIsbn));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("authors")
    public List<Authors> getAllAuthors() {
        return this.authorsRepository.findAll();
    }


    @GetMapping("/books/authors/")
    public ResponseEntity<List<Books>> findAuthor(@RequestParam(required = false) String author) {
        try {
            List<Books> books = new ArrayList<Books>();

            if (author == null)
                bookRepository.findAll().forEach(books::add);
            else
                bookRepository.findByAuthor(author).forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create Book
    @PostMapping("books/newBook")
    public Books createBook(@RequestBody Books book_name) {
        return bookRepository.save(book_name);
    }

    // Create Author
    @PostMapping("authors/newAuthor")
    public Authors createAuthor(@RequestBody Authors getF_name) {
        return authorsRepository.save(getF_name);
    }


}
