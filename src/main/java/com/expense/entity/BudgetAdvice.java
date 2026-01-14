package com.expense.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BudgetAdvice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String advice;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    public BudgetAdvice() {}

    public BudgetAdvice(String advice, User user) {
        this.advice = advice;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getAdvice() {
        return advice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
