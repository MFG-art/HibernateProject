package com.example.hibernate_project.controllers;

import com.example.hibernate_project.models.Book;
import com.example.hibernate_project.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
This Controller class was based off of the one listed in the Spring.io tutorials page
 */

@RestController
public class BookController {
    private final BookRepository bookRepository;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    GET ALL
    @GetMapping("/books")
    List<Book> all() {
        return bookRepository.findAll();
    }

    //    POST
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    //    SINGLE ITEM GET
    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    //    PUT
    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            return bookRepository.save(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return bookRepository.save(newBook);
        });
    }

    //    DELETE
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
