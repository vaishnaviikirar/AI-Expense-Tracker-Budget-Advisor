package com.expense.controller;

import com.expense.security.JwtUtil;
import com.expense.service.AiSuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class AiSuggestionController {

    private final AiSuggestionService aiSuggestionService;
    private final JwtUtil jwtUtil;

    public AiSuggestionController(AiSuggestionService aiSuggestionService,
                                  JwtUtil jwtUtil) {
        this.aiSuggestionService = aiSuggestionService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/suggestions")
    public List<String> getSuggestions(@RequestHeader("Authorization") String token) {

        String username = jwtUtil.extractUsername(token.substring(7));
        return aiSuggestionService.generateSuggestions(username);
    }
}
