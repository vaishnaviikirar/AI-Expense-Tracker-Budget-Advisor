package com.expense.service;

import com.expense.dto.AiRequestDto;
import com.expense.dto.AnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class MonthlyAiSuggestionService {

    public String generateMonthlyAdvice(AiRequestDto data) {

        StringBuilder advice = new StringBuilder();
        advice.append("📊 Monthly Budget Analysis:\n\n");

        if (data.getProfitLoss() < 0) {
            advice.append("- You are overspending this month. Consider reducing non-essential expenses.\n");
        } else {
            advice.append("- You are within budget. Good financial discipline.\n");
        }

        if (data.getTotalExpense() > data.getMonthlyIncome() * 0.8) {
            advice.append("- Expenses exceed 80% of income. Try saving at least 20%.\n");
        }

        data.getCategorySummary().forEach((category, amount) -> {
            if (amount > data.getMonthlyIncome() * 0.3) {
                advice.append("- High spending in ").append(category)
                        .append(". Consider cutting down.\n");
            }
        });

        advice.append("\n💡 Tip: Track daily expenses to avoid month-end surprises.");

        return advice.toString();
    }
}
