/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 *
 * Entity/Model Loan
 */
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrower_name", nullable = false)
    private String borrowerName;

    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    public Loan() {
    }

    public Loan(String borrowerName, LocalDate loanDate, Book book) {
        this.borrowerName = borrowerName;
        this.loanDate = loanDate;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
