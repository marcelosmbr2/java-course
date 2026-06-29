/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.models;

/**
 *
 * @author marce
 */

// Inheritance with "extends"
// Inheritance allows a class to reuse attributes and behaviors from a more general class
public class Admin extends User {
    
    // Constructor
    public Admin(String name, String email) {
        super(name, email);
    }

    // Implementing the abstraction of this User method
    @Override
    public void showPermissions() {
        System.out.println("Pode adicionar e remover livros.");
    }
}
