/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.repository;

import com.marcelosmbr.api_hibernate.entity.Category;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Repository responsible for database operations
 * related to Category entities.
 */
public class CategoryRepository {

    private final EntityManager entityManager;

    public CategoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager
                .createQuery("SELECT c FROM Category c", Category.class)
                .getResultList();
    }

    public void delete(Category category) {
        entityManager.remove(category);
    }
}
