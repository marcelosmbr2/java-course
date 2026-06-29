/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_spring.service;

import com.marcelosmbr.api_spring.entity.Book;
import com.marcelosmbr.api_spring.entity.Loan;
import com.marcelosmbr.api_spring.repository.BookRepository;
import com.marcelosmbr.api_spring.repository.LoanRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public LoanService(
            LoanRepository loanRepository,
            BookRepository bookRepository
    ) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    public Loan createLoan(String borrowerName, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found."));

        Loan loan = new Loan(
                borrowerName,
                LocalDate.now(),
                book
        );

        return loanRepository.save(loan);
    }

    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found."));

        if (loan.getReturnDate() != null) {
            throw new IllegalStateException("This loan has already been returned.");
        }

        loan.setReturnDate(LocalDate.now());

        loanRepository.save(loan);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public List<Loan> findOpenLoans() {
        return loanRepository.findByReturnDateIsNull();
    }
}
