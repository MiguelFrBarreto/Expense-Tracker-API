package com.example.ExpenseTracker.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public Expense getById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense not found"));

        return expense;
    }

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public Expense create(ExpenseDTO dto) {
        Expense expense = new Expense(dto.description(), dto.amount(), dto.date(), dto.type());

        return expenseRepository.save(expense);
    }

    public Expense update(Expense newExpense, Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense not found"));

        expense.setDescription(newExpense.getDescription());
        expense.setAmount(newExpense.getAmount());
        expense.setDate(newExpense.getDate());
        expense.setType(newExpense.getType());
        expense.setCategory(newExpense.getCategory());

        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense not found"));

        expenseRepository.delete(expense);
    }
}
