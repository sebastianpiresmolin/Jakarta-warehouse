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
        products.add(new Product(1, "Milk", Category.DAIRY, 5, LocalDate.now(), LocalDate.now()));
        products.add(new Product(2, "Carrot", Category.VEGETABLE, 4, LocalDate.now(), LocalDate.now()));
    }

    public List<Product> getProducts() {

        return List.copyOf(products);
    }
}
