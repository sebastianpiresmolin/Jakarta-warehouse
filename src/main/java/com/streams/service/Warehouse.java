package com.streams.service;


import com.streams.entities.Category;
import com.streams.entities.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
public class Warehouse {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    public Warehouse() {
        initializeWarehouseWithDefaultProducts();
    }

    private void initializeWarehouseWithDefaultProducts() {
        products.add(createProduct(1, "Milk", Category.DAIRY, 5));
        products.add(createProduct(2, "Carrot", Category.VEGETABLE, 4));
    }

    private Product createProduct(int id, String name, Category category, int rating) {
        return new Product(id, name, category, rating, LocalDate.now(), LocalDate.now());
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No product found with given id"));
    }
}
