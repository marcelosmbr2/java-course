/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.models;

import com.mycompany.main.interfaces.Borrowable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */

// Inheritance with "extends"
// Inheritance allows a class to reuse attributes and behaviors from a more general class
public class Client extends User implements Borrowable {

    private List<Book> borrowedBooks = new ArrayList<>();

     // Constructor
    public Client(String name, String email) {
        super(name, email);
    }

    // Implementing the abstraction of the interface method
    @Override
    public void borrowBook(Book book) {

        if(book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
        }
    }
    
    // Implementing the abstraction of the interface method
    @Override
    public void returnBook(Book book) {

        book.returnBook();
        borrowedBooks.remove(book);
    }

    // Implementing the abstraction of this User method
    @Override
    public void showPermissions() {
        System.out.println("Pode emprestar livros.");
    }
}
