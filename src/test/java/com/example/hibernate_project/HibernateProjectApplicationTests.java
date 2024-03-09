package com.example.hibernate_project;

import com.example.hibernate_project.models.Book;
import com.example.hibernate_project.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HibernateProjectApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Book> books = bookService.list();
        assert books.size() == 3;
    }

}
