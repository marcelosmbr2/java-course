/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import com.mycompany.main.models.*;

/**
 *
 * @author marce
 */
public class Main {

    public static void main(String[] args) {
        
        // Encapsulation protects data
        // Inheritance reuses code
        // Abstraction defines the essential structure
        // Polymorphism enables different behaviors through a common interface
        
        Library library = new Library();

        Book book1 = new Book("Clean Code");
        Book book2 = new Book("Design Patterns");

        library.addBook(book1);
        library.addBook(book2);

        // An Admin is also an User
        // This could be Admin admin
        User admin = new Admin(
                "Carlos",
                "carlos@email.com"
        );

        // An Client is also an User
        // But client cant be defined just as an User because only Client implements Borrowable
        Client client = new Client(
                "Maria",
                "maria@email.com"
        );

        // Polymorphism (allowed by the abstraction of showPermissions User method)
        // Polymorphism allows different objects to respond differently to the same method call
        admin.showPermissions();
        client.showPermissions();
        
        client.borrowBook(book1);
        library.listBooks();
    }
}
