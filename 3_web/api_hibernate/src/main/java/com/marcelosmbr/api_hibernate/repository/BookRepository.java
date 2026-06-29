/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.repository;

import com.marcelosmbr.api_hibernate.entity.Book;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Repository responsible for database operations
 * related to Book entities.
 */
public class BookRepository {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return entityManager
                .createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    public List<Book> findByCategory(Long categoryId) {
        return entityManager
                .createQuery(
                        "SELECT b FROM Book b WHERE b.category.id = :categoryId",
                        Book.class
                )
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public void delete(Book book) {
        entityManager.remove(book);
    }
}
