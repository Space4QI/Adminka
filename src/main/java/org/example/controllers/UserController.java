package org.example.controllers;

import org.springframework.web.bind.annotation.*;
import org.example.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RequestMapping("/users")
@RestController
public class UserController {

    private final List<User> users = new ArrayList<>(Arrays.asList(
            new User(1L, "John Doe", "john@mail.com"),
            new User(2L, "Misha Doe", "misha@mail.com")
    ));

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // Возвращаем null если пользователь не найден
    }

    // Метод добавления нового пользователя
    @PostMapping("/postUser")
    public User addUser(@RequestBody User user) {
        // Присваиваем новому пользователю уникальный id (просто для примера)
        Long newId = Long.valueOf(users.size() + 1);
        user.setId(newId);
        users.add(user);
        return user;
    }
}