package com.expense.service;

import com.expense.dto.AnalyticsResponse;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonthlyAnalyticsService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public MonthlyAnalyticsService(ExpenseRepository expenseRepository,
                                   UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public AnalyticsResponse generateMonthlyReport(String username) {

        User user = userRepository.findByUsername(username);
        List<Expense> expenses = expenseRepository.findByUser(user);

        Map<String, Double> categoryTotals = new HashMap<>();
        double total = 0;

        for (Expense e : expenses) {
            categoryTotals.put(
                    e.getCategory(),
                    categoryTotals.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
            );
            total += e.getAmount();
        }

        return new AnalyticsResponse(categoryTotals, total);
    }
}
