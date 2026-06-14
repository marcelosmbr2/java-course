/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_spring.controller;

import com.marcelosmbr.api_spring.dto.CreateBookRequest;
import com.marcelosmbr.api_spring.entity.Book;
import com.marcelosmbr.api_spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody CreateBookRequest request) {
        return bookService.createBook(
                request.title(),
                request.author(),
                request.categoryId()
        );
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Book> findByCategory(@PathVariable Long categoryId) {
        return bookService.findByCategory(categoryId);
    }
}
