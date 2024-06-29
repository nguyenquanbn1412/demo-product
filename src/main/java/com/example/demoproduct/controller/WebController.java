package com.example.demoproduct.controller;


import com.example.demoproduct.security.IAuthenticationFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("info-5")
    public ResponseEntity<?> getInfo5() {
        return ResponseEntity.ok(authenticationFacade.getAuthentication());
    }

    @GetMapping("info-1")
    public ResponseEntity<?> getInfo1() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("info-2")
    public ResponseEntity<?> getInfo2(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("info-3")
    public ResponseEntity<?> getInfo3(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("info-4")
    public ResponseEntity<?> getInfo4(HttpServletRequest request) {
        return ResponseEntity.ok(request.getUserPrincipal());
    }

    @GetMapping("/")
    public String getHome() {
        return "Home";
    }
    ///////////////////
    @GetMapping("/dashboard")
    public String getDashboard() {
        return "Dashboard";
    }

}
