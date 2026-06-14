/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.models;

/**
 *
 * @author marce
 */

// Abstraction with "abstract"
// Abstraction focuses on the essential characteristics of an entity while hiding unnecessary details
public abstract class User {

    private String name;
    private String email;

     // Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    // The User class defines that every user must have permissions, but it does not specify what those permissions are
    // The class that inherits this one implements this method with @override
    public abstract void showPermissions();

}
