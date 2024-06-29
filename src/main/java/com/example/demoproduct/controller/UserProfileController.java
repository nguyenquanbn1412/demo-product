package com.example.demoproduct.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    @GetMapping
    public String getProfile() {
        return "Profile";
    }

    @PutMapping
    public String updateProfile() {
        return "Updated";
    }
}
