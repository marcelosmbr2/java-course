/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.repository;

import com.marcelosmbr.api_hibernate.entity.Loan;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Repository responsible for database operations
 * related to Loan entities.
 */
public class LoanRepository {

    private final EntityManager entityManager;

    public LoanRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Loan loan) {
        entityManager.persist(loan);
    }

    public Loan findById(Long id) {
        return entityManager.find(Loan.class, id);
    }

    public List<Loan> findAll() {
        return entityManager
                .createQuery("SELECT l FROM Loan l", Loan.class)
                .getResultList();
    }

    public List<Loan> findOpenLoans() {
        return entityManager
                .createQuery(
                        "SELECT l FROM Loan l WHERE l.returnDate IS NULL",
                        Loan.class
                )
                .getResultList();
    }

    public void delete(Loan loan) {
        entityManager.remove(loan);
    }
}
