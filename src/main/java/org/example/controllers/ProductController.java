package org.example.controllers;

import org.example.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1L, "Product A", 10.0),
                new Product(2L, "Product B", 20.0)
        );
    }
}