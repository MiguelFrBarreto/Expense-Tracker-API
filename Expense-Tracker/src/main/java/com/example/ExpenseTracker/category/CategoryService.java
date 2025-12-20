package com.example.ExpenseTracker.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("category not found"));

        return category;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category create(CategoryDTO dto) {
        Category category = new Category(dto.name());

        return categoryRepository.save(category);
    }

    public Category update(Category newCategory, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("category not found"));

        category.setName(newCategory.getName());
        category.setExpense(newCategory.getExpense());

        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("category not found"));

        categoryRepository.delete(category);
    }
}
