package com.expense.dto;

import java.util.Map;

public class AiRequestDto {

    private Double monthlyIncome;
    private Double totalExpense;
    private Double profitLoss;
    private Map<String, Double> categorySummary;

    public AiRequestDto() {}

    public AiRequestDto(Double monthlyIncome,
                        Double totalExpense,
                        Double profitLoss,
                        Map<String, Double> categorySummary) {
        this.monthlyIncome = monthlyIncome;
        this.totalExpense = totalExpense;
        this.profitLoss = profitLoss;
        this.categorySummary = categorySummary;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Map<String, Double> getCategorySummary() {
        return categorySummary;
    }

    public void setCategorySummary(Map<String, Double> categorySummary) {
        this.categorySummary = categorySummary;
    }
}
