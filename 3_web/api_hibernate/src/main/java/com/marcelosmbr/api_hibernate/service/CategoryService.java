/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.service;

import com.marcelosmbr.api_hibernate.entity.Category;
import com.marcelosmbr.api_hibernate.repository.CategoryRepository;
import jakarta.persistence.EntityManager;

/**
 * Service responsible for business rules operations
 * related to Category entities
 */
public class CategoryService {

    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;

    public CategoryService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.categoryRepository =
                new CategoryRepository(entityManager);
    }

    public Category createCategory(String name) {

        Category category = new Category(name);

        entityManager.getTransaction().begin();

        try {

            categoryRepository.save(category);

            entityManager.getTransaction().commit();

            return category;

        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            throw ex;
        }
    }
}
