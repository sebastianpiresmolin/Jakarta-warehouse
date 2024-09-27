package com.streams.resources;

import com.streams.entities.Product;
import com.streams.service.Warehouse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class WarehouseResource {
    private final Warehouse warehouse;

    @Inject
    public WarehouseResource(Warehouse warehouse) {
        System.out.println("WarehouseResource object created");
        this.warehouse = warehouse;
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
        return warehouse.getProductById(Integer.parseInt(id));
    }


}