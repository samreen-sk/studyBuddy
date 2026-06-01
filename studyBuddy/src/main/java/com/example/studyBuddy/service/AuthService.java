package com.example.studyBuddy.service;

import com.example.studyBuddy.dto.AuthRequest;
import com.example.studyBuddy.dto.AuthResponse;
import com.example.studyBuddy.entity.User;
import com.example.studyBuddy.repository.UserRepository;
import com.example.studyBuddy.security.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public String register(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByEmail(
                request.getEmail()
        ).orElseThrow();

        boolean matches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!matches) {
            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        String token =
                jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}

