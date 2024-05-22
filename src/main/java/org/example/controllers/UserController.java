package org.example.controllers;

import org.example.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return Arrays.asList(
                new User(1L, "John Doe", "john@mail.com"),
                new User(2L, "Misha Doe", "misha@mail.com")
        );
    }
}