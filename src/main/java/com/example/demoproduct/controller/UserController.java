package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Users";
    }

    @PostMapping
    public String createUser() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id) {
        return "Updated: " + id;
    }
}