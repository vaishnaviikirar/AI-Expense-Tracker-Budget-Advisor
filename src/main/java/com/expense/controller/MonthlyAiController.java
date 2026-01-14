package com.expense.controller;

import com.expense.dto.AnalyticsResponse;
import com.expense.security.JwtUtil;
import com.expense.service.MonthlyAnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin
public class MonthlyAiController {

    private final MonthlyAnalyticsService analyticsService;
    private final JwtUtil jwtUtil;

    public MonthlyAiController(MonthlyAnalyticsService analyticsService,
                               JwtUtil jwtUtil) {
        this.analyticsService = analyticsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/monthly")
    public AnalyticsResponse getMonthlyReport(@RequestHeader("Authorization") String token) {

        String username = jwtUtil.extractUsername(token.substring(7));
        return analyticsService.generateMonthlyReport(username);
    }
}
