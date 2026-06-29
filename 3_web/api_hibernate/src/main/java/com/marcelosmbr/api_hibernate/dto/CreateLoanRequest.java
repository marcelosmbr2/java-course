/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.dto;

/**
 * Data Transfer Object (DTO) used to receive
 * the data required to create a new loan.
 */
public record CreateLoanRequest(
        String borrowerName,
        Long bookId
) {
}
