package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public String getPosts() {
        return "Posts";
    }

    @PostMapping
    public String createPost() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id) {
        return "Updated: " + id;
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        return "Deleted: " + id;
    }
}
