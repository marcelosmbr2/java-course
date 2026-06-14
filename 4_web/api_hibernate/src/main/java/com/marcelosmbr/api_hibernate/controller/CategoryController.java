/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcelosmbr.api_hibernate.controller;

import com.marcelosmbr.api_hibernate.dto.CreateCategoryRequest;
import com.marcelosmbr.api_hibernate.entity.Category;
import com.marcelosmbr.api_hibernate.service.CategoryService;

/*
 * Controller Layer
 *
 * Handle incoming requests and delegate
 * work to the category service layer
*/
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category create(CreateCategoryRequest request) {
        return categoryService.createCategory(request.name());
    }
}
