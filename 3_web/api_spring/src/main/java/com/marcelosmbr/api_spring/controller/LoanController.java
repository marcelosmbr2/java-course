/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_spring.controller;

import com.marcelosmbr.api_spring.dto.CreateLoanRequest;
import com.marcelosmbr.api_spring.entity.Loan;
import com.marcelosmbr.api_spring.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan create(@RequestBody CreateLoanRequest request) {
        return loanService.createLoan(
                request.borrowerName(),
                request.bookId()
        );
    }

    @GetMapping
    public List<Loan> findAll() {
        return loanService.findAll();
    }

    @GetMapping("/open")
    public List<Loan> findOpenLoans() {
        return loanService.findOpenLoans();
    }

    @PutMapping("/{id}/return")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
    }
}
