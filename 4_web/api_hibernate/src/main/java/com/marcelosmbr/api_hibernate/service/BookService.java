/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.service;

import java.util.List;
import com.marcelosmbr.api_hibernate.entity.Book;
import com.marcelosmbr.api_hibernate.entity.Category;
import com.marcelosmbr.api_hibernate.repository.BookRepository;
import com.marcelosmbr.api_hibernate.repository.CategoryRepository;
import jakarta.persistence.EntityManager;

/**
 * Service responsible for business rules operations
 * related to Book entities
 */
public class BookService {

    private final EntityManager entityManager;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bookRepository = new BookRepository(entityManager);
        this.categoryRepository = new CategoryRepository(entityManager);
    }

    public Book createBook(
            String title,
            String author,
            Long categoryId
    ) {

        Category category
                = categoryRepository.findById(categoryId);

        if (category == null) {
            throw new IllegalArgumentException(
                    "Category not found."
            );
        }

        Book book = new Book(
                title,
                author,
                category
        );

        entityManager.getTransaction().begin();

        try {

            bookRepository.save(book);

            entityManager.getTransaction().commit();

            return book;

        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            throw ex;
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
}
