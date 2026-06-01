package com.example.studyBuddy.controller;

import com.example.studyBuddy.dto.AuthRequest;
import com.example.studyBuddy.dto.AuthResponse;
import com.example.studyBuddy.entity.User;
import com.example.studyBuddy.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody User user
    ) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request
    ) {
        return authService.login(request);
    }
}

