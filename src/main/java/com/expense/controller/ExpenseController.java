package com.expense.controller;

import com.expense.entity.Expense;
import com.expense.security.JwtUtil;
import com.expense.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
public class ExpenseController {

    private final ExpenseService expenseService;
    private final JwtUtil jwtUtil;

    public ExpenseController(ExpenseService expenseService, JwtUtil jwtUtil) {
        this.expenseService = expenseService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense,
                              @RequestHeader("Authorization") String token) {

        String username = jwtUtil.extractUsername(token.substring(7));
        return expenseService.addExpense(expense, username);
    }

    @GetMapping
    public List<Expense> getExpenses(@RequestHeader("Authorization") String token) {

        String username = jwtUtil.extractUsername(token.substring(7));
        return expenseService.getExpenses(username);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id,
                              @RequestHeader("Authorization") String token) {

        String username = jwtUtil.extractUsername(token.substring(7));
        expenseService.deleteExpense(id, username);
    }
}
