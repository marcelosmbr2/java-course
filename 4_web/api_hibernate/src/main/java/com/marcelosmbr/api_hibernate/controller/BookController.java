/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.controller;

import com.marcelosmbr.api_hibernate.dto.CreateBookRequest;
import com.marcelosmbr.api_hibernate.entity.Book;
import com.marcelosmbr.api_hibernate.service.BookService;
import java.util.List;

/*
 * Controller Layer
 *
 * Handle incoming requests and delegate
 * work to the book service layer
*/
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public Book create(CreateBookRequest request) {
        return bookService.createBook(
                request.title(),
                request.author(),
                request.categoryId()
        );
    }

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public Book findById(Long id) {
        return bookService.findById(id);
    }
}
