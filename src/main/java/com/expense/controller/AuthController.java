package com.expense.controller;

import com.expense.entity.User;
import com.expense.repository.UserRepository;
import com.expense.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User req) {
        User user = repo.findByUsername(req.getUsername());

        if (user == null || !user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return Map.of("token", token);
    }


}
