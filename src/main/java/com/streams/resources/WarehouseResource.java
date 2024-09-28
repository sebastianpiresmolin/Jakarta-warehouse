package com.streams.resources;

import com.streams.entities.Category;
import com.streams.entities.Product;
import com.streams.service.Warehouse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class WarehouseResource {
    @Inject
    private Warehouse warehouse;

    public WarehouseResource() {
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return warehouse.getProducts();
    }

    @Path("/products/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") String id) {
        return warehouse.getProductsById(Integer.parseInt(id));
    }

    @Path("/products/category/{category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByCategory(@PathParam("category") String categoryString) {
        Category category = Category.valueOf(categoryString.toUpperCase());
        return warehouse.getProductsByCategory(category);
    }


}