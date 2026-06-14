/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.main.interfaces;

import com.mycompany.main.models.Book;

/**
 *
 * @author marce
 */

// Abstraction with "interface"
// Abstraction focuses on the essential characteristics of an entity while hiding unnecessary details
public interface Borrowable {
    void borrowBook(Book book);
    void returnBook(Book book);
}
