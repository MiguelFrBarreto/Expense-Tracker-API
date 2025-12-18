package com.example.ExpenseTracker.expense;

import java.time.Instant;

import com.example.ExpenseTracker.category.Category;
import com.example.ExpenseTracker.enums.Type;
import com.example.ExpenseTracker.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private Instant date;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    Category category;

    public Expense(String description, Double amount, Instant date, Type type) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
}
