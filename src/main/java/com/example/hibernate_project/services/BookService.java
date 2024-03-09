package com.example.hibernate_project.services;

import com.example.hibernate_project.models.Book;
import com.example.hibernate_project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list()  {
        return bookRepository.findAll();
    }
}
