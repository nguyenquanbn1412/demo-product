package com.example.demoproduct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String getOrders() {
        return "Orders";
    }

    @PostMapping
    public String createOrder() {
        return "Created";
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable Long id) {
        return "Updated: " + id;
    }
}
