package com.example.hibernate_project.controllers;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(Long id) {
        super("Book with an id of " + id + " could not be found");
    }
}
