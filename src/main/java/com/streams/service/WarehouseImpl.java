package com.streams.service;

import com.streams.entities.Category;
import com.streams.entities.Product;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Named("Impl")
@ApplicationScoped
public class WarehouseImpl implements WarehouseService {

    private final List<Product> products = Collections.synchronizedList(new ArrayList<Product>());

    public WarehouseImpl() {
        initializeWarehouseWithDefaultProducts();
    }

    private void initializeWarehouseWithDefaultProducts() {
        products.add(createProduct(1, "Milk", Category.DAIRY, 5));
        products.add(createProduct(2, "Carrot", Category.VEGETABLE, 4));
    }

    private Product createProduct(int id, String name, Category category, int rating) {
        return new Product(id, name, category, rating, LocalDate.now(), LocalDate.now());
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    @Override
    public Product getProductsById(int id) {
        return products.stream()
                .filter(product -> product.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No product found with given id: " + id));
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.category() == category)
                .sorted(Comparator.comparing(Product::name))
                .collect(Collectors.toList());
    }
}