package com.expense.util;

import java.time.LocalDate;
import java.time.YearMonth;

public class DateUtils {

    // First day of current month
    public static LocalDate getStartOfCurrentMonth() {
        YearMonth currentMonth = YearMonth.now();
        return currentMonth.atDay(1);
    }

    // Last day of current month
    public static LocalDate getEndOfCurrentMonth() {
        YearMonth currentMonth = YearMonth.now();
        return currentMonth.atEndOfMonth();
    }

    // Check if date is in current month
    public static boolean isInCurrentMonth(LocalDate date) {
        YearMonth now = YearMonth.now();
        return YearMonth.from(date).equals(now);
    }
}
