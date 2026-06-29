/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_spring.service;

import com.marcelosmbr.api_spring.entity.Book;
import com.marcelosmbr.api_spring.entity.Category;
import com.marcelosmbr.api_spring.repository.BookRepository;
import com.marcelosmbr.api_spring.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(
            BookRepository bookRepository,
            CategoryRepository categoryRepository
    ) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public Book createBook(String title, String author, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found."));

        Book book = new Book(title, author, category);

        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }
}
