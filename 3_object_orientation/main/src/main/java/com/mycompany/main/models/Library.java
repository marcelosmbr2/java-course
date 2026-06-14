/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {

        for(Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}
