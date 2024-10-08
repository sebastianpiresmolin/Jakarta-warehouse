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
        products.add(createProduct(1, "Milk", Category.DAIRY, 7));
        products.add(createProduct(2, "Cheese", Category.DAIRY, 9));
        products.add(createProduct(3, "Yogurt", Category.DAIRY, 6));
        products.add(createProduct(4, "Butter", Category.DAIRY, 8));
        products.add(createProduct(5, "Cream", Category.DAIRY, 8));

        products.add(createProduct(6, "Apple", Category.FRUIT, 7));
        products.add(createProduct(7, "Banana", Category.FRUIT, 9));
        products.add(createProduct(8, "Cherry", Category.FRUIT, 6));
        products.add(createProduct(9, "Date", Category.FRUIT, 4));
        products.add(createProduct(10, "Kiwi", Category.FRUIT, 8));

        products.add(createProduct(11, "Broccoli", Category.VEGETABLE, 5));
        products.add(createProduct(12, "Carrot", Category.VEGETABLE, 7));
        products.add(createProduct(13, "Pea", Category.VEGETABLE, 6));
        products.add(createProduct(14, "Cabbage", Category.VEGETABLE, 5));
        products.add(createProduct(15, "Iceberg lettuce", Category.VEGETABLE, 4));

        products.add(createProduct(16, "Salmon", Category.FISH, 8));
        products.add(createProduct(17, "Tuna", Category.FISH, 7));
        products.add(createProduct(18, "Trout", Category.FISH, 6));
        products.add(createProduct(19, "Cod", Category.FISH, 5));
        products.add(createProduct(20, "Herring", Category.FISH, 7));

        products.add(createProduct(21, "Beef", Category.MEAT, 8));
        products.add(createProduct(22, "Chicken", Category.MEAT, 7));
        products.add(createProduct(23, "Lamb", Category.MEAT, 6));
        products.add(createProduct(24, "Pork", Category.MEAT, 5));
        products.add(createProduct(25, "Turkey", Category.MEAT, 4));

        products.add(createProduct(26, "Bread", Category.EMPTY, 3));
        products.add(createProduct(27, "Cereal", Category.EMPTY, 6));
        products.add(createProduct(28, "Noodles", Category.EMPTY, 7));
        products.add(createProduct(29, "Rice", Category.EMPTY, 4));
        products.add(createProduct(30, "Oats", Category.EMPTY, 8));
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