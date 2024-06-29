package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public String getCategories() {
        return "Categories";
    }

    @PostMapping
    public String createCategory() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Integer id) {
        return "Updated: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return "Deleted: " + id;
    }
}
