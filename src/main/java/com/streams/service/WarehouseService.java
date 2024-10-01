package com.streams.service;

import com.streams.entities.Category;
import com.streams.entities.Product;

import java.util.List;

public interface WarehouseService {
    void addProduct(Product product);
    List<Product> getProducts();
    Product getProductsById(int id);
    List<Product> getProductsByCategory(Category category);
}
