package com.expense.dto;

import java.util.Map;

public class AnalyticsResponse {

    private Map<String, Double> categoryTotals;
    private double totalExpense;

    public AnalyticsResponse(Map<String, Double> categoryTotals, double totalExpense) {
        this.categoryTotals = categoryTotals;
        this.totalExpense = totalExpense;
    }

    public Map<String, Double> getCategoryTotals() {
        return categoryTotals;
    }

    public double getTotalExpense() {
        return totalExpense;
    }
}
