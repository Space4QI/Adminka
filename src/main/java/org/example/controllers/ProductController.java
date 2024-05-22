package org.example.controllers;

import org.example.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RequestMapping("/products")
@RestController
public class ProductController {

    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1L, "Product A", 10.0),
            new Product(2L, "Product B", 20.0)
    ));

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; // Возвращаем null если продукт не найден
    }

    // Метод добавления нового продукта
    @PostMapping("/postProduct")
    public Product addProduct(@RequestBody Product product) {
        Long newId = Long.valueOf(products.size() + 1);
        product.setId(newId);
        products.add(product);
        return product;
    }
}