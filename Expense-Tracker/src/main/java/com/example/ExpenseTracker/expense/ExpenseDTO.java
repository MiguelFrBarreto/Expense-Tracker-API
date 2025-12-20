package com.example.ExpenseTracker.expense;

import java.time.Instant;

import com.example.ExpenseTracker.enums.Type;

public record ExpenseDTO (String description, Double amount, Instant date, Type type) {
    
}
