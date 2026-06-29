/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.service;

import java.time.LocalDate;
import com.marcelosmbr.api_hibernate.entity.Loan;
import com.marcelosmbr.api_hibernate.entity.Book;
import com.marcelosmbr.api_hibernate.repository.BookRepository;
import com.marcelosmbr.api_hibernate.repository.LoanRepository;
import jakarta.persistence.EntityManager;

/**
 * Service responsible for business rules operations
 * related to Loan entities
 */
public class LoanService {

    private final EntityManager entityManager;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public LoanService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.loanRepository = new LoanRepository(entityManager);
        this.bookRepository = new BookRepository(entityManager);
    }

    public Loan createLoan(String borrowerName, Long bookId) {
        Book book = bookRepository.findById(bookId);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        Loan loan = new Loan(
                borrowerName,
                LocalDate.now(),
                book
        );

        entityManager.getTransaction().begin();

        try {
            loanRepository.save(loan);

            entityManager.getTransaction().commit();

            return loan;

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        }
    }

    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId);

        if (loan == null) {
            throw new IllegalArgumentException("Loan not found.");
        }

        if (loan.getReturnDate() != null) {
            throw new IllegalStateException("This loan has already been returned.");
        }

        entityManager.getTransaction().begin();

        try {
            loan.setReturnDate(LocalDate.now());

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        }
    }
}
