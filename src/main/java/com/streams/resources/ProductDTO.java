package com.streams.resources;

import com.streams.entities.Category;
import com.streams.entities.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProductDTO {
    @NotNull
    @Min(1)
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    private String category;

    @NotNull
    @Min(0)
    @Max(10)
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
