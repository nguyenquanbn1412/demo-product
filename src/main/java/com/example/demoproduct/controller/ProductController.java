package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getProducts() {
        return "Products";
    }

    @PostMapping
    public String createProduct() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id) {
        return "Updated: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "Deleted: " + id;
    }
}
