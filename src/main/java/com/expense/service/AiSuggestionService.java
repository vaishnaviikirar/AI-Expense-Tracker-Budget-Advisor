package com.expense.service;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AiSuggestionService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public AiSuggestionService(ExpenseRepository expenseRepository,
                               UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<String> generateSuggestions(String username) {

        User user = userRepository.findByUsername(username);
        List<Expense> expenses = expenseRepository.findByUser(user);

        double total = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        List<String> suggestions = new ArrayList<>();

        if (total > 20000) {
            suggestions.add("Your expenses are high this month. Try cutting down on unnecessary purchases.");
        }

        long foodCount = expenses.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase("Food"))
                .count();

        if (foodCount > 10) {
            suggestions.add("You are spending frequently on food. Consider meal planning.");
        }

        if (suggestions.isEmpty()) {
            suggestions.add("Your spending looks balanced. Keep tracking regularly.");
        }

        return suggestions;
    }
}
