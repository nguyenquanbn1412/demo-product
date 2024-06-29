package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @GetMapping
    public String getBrands() {
        return "Brands";
    }

    @PostMapping
    public String createBrand() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updateBrand(@PathVariable Long id) {
        return "Updated: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable Long id) {
        return "Deleted: " + id;
    }
}
