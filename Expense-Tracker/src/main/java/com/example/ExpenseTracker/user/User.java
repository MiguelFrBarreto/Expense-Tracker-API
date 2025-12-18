package com.example.ExpenseTracker.user;

import java.util.HashSet;
import java.util.Set;

import com.example.ExpenseTracker.category.Category;
import com.example.ExpenseTracker.expense.Expense;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    Set<Expense> expenses = new HashSet<>();

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
