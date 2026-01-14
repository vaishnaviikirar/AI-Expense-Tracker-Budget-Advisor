package com.expense.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BudgetRuleEngine {

    /**
     * Apply basic budgeting rules
     */
    public static List<String> generateAdvice(
            double income,
            double totalExpense,
            Map<String, Double> categorySummary) {

        List<String> advice = new ArrayList<>();

        // Rule 1: Overspending
        if (totalExpense > income) {
            advice.add("You are spending more than your income. Reduce non-essential expenses.");
        }

        // Rule 2: Low savings
        if (income - totalExpense < income * 0.1) {
            advice.add("Your savings are below 10%. Try to save at least 10–20% of income.");
        }

        // Rule 3: High category spending
        for (Map.Entry<String, Double> entry : categorySummary.entrySet()) {
            if (entry.getValue() > income * 0.3) {
                advice.add("High spending detected in " + entry.getKey() +
                        ". Consider reducing expenses in this category.");
            }
        }

        if (advice.isEmpty()) {
            advice.add("Your spending looks healthy. Keep maintaining this balance.");
        }

        return advice;
    }
}
