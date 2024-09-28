package com.streams.resources;

import com.streams.entities.Category;
import com.streams.entities.Product;

import java.time.LocalDate;

public class ProductDTO {
    private int id;
    private String name;
    private String category;
    private int rating;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product toProduct() {
        Category category = Category.valueOf(this.getCategory().toUpperCase());
        return new Product(this.getId(),
                this.getName(),
                category,
                this.getRating(),
                LocalDate.now(),
                LocalDate.now());
    }
}
