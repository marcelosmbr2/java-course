/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utility class responsible for managing the EntityManagerFactory and
 * EntityManager instances.
 *
 * Provides access to the persistence context.
 */
public class JPAUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("HibernatePU");

    /**
     * Creates and returns a new EntityManager.
     *
     * @return EntityManager instance
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Closes the EntityManagerFactory and releases resources.
     */
    public static void close() {
        emf.close();
    }
}
