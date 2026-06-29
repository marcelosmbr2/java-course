/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.marcelosmbr.api_hibernate;

import io.javalin.Javalin;
import jakarta.persistence.EntityManager;

import com.marcelosmbr.api_hibernate.config.JPAUtil;
import com.marcelosmbr.api_hibernate.controller.BookController;
import com.marcelosmbr.api_hibernate.controller.CategoryController;
import com.marcelosmbr.api_hibernate.controller.LoanController;
import com.marcelosmbr.api_hibernate.service.BookService;
import com.marcelosmbr.api_hibernate.service.CategoryService;
import com.marcelosmbr.api_hibernate.service.LoanService;


/**
 * Application Entry Point.
 *
 * This class is responsible for:
 *
 * - Starting the HTTP server
 * - Initializing application dependencies
 * - Creating services and controllers
 * - Registering routes
 * - Managing application lifecycle
 *
 * This class acts as the application's bootstrap.
 * 
 * Possible Refactoring: 
 * Extract the server initialization, classes, and routes to separate files
 * 
 * */

public class Api_Hibernate {

    public static void main(String[] args) {
        
        EntityManager entityManager = JPAUtil.getEntityManager();

        BookService bookService = new BookService(entityManager);
        CategoryService categoryService = new CategoryService(entityManager);
        LoanService loanService = new LoanService(entityManager);

        BookController bookController = new BookController(bookService);
        CategoryController categoryController = new CategoryController(categoryService);
        LoanController loanController = new LoanController(loanService);

        Javalin app = Javalin.create().start(7000);

        app.get("/", ctx -> ctx.result("Library API is running"));

        app.post("/categories", ctx -> {
            var request = ctx.bodyAsClass(
                    com.marcelosmbr.api_hibernate.dto.CreateCategoryRequest.class
            );

            var category = categoryController.create(request);

            ctx.status(201).json(category);
        });

        app.get("/books", ctx -> {
            ctx.json(bookController.findAll());
        });

        app.get("/books/{id}", ctx -> {
            Long id = Long.valueOf(ctx.pathParam("id"));

            var book = bookController.findById(id);

            if (book == null) {
                ctx.status(404).result("Book not found");
                return;
            }

            ctx.json(book);
        });

        app.post("/books", ctx -> {
            var request = ctx.bodyAsClass(
                    com.marcelosmbr.api_hibernate.dto.CreateBookRequest.class
            );

            var book = bookController.create(request);

            ctx.status(201).json(book);
        });

        app.post("/loans", ctx -> {
            var request = ctx.bodyAsClass(
                    com.marcelosmbr.api_hibernate.dto.CreateLoanRequest.class
            );

            var loan = loanController.create(request);

            ctx.status(201).json(loan);
        });

        app.put("/loans/{id}/return", ctx -> {
            Long id = Long.valueOf(ctx.pathParam("id"));

            loanController.returnBook(id);

            ctx.status(204);
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            entityManager.close();
            JPAUtil.close();
        }));
        
    }
}
