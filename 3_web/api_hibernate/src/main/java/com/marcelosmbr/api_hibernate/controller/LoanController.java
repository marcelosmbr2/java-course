/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.controller;

import com.marcelosmbr.api_hibernate.dto.CreateLoanRequest;
import com.marcelosmbr.api_hibernate.entity.Loan;
import com.marcelosmbr.api_hibernate.service.LoanService;

/*
 * Controller Layer
 *
 * Handle incoming requests and delegate
 * work to the loan service layer
*/
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public Loan create(CreateLoanRequest request) {
        return loanService.createLoan(
                request.borrowerName(),
                request.bookId()
        );
    }

    public void returnBook(Long loanId) {
        loanService.returnBook(loanId);
    }
}
