package com.expense.service;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Expense addExpense(Expense expense, String username) {
        User user = userRepository.findByUsername(username);
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpenses(String username) {
        User user = userRepository.findByUsername(username);
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id, String username) {
        expenseRepository.deleteById(id);
    }
}
