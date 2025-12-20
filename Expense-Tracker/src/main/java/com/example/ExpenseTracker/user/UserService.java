package com.example.ExpenseTracker.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User create(UserDTO dto) {
        User user = new User(dto.name(), dto.email(), dto.password());

        return userRepository.save(user);
    }

    public User update(User newUser, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setCategories(newUser.getCategories());
        user.setExpenses(newUser.getExpenses());

        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.delete(user);
    }
}