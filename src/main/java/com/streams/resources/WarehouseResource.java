package com.streams.resources;

import com.streams.entities.Category;
import com.streams.entities.Product;
import com.streams.service.Warehouse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
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

    @POST
    @Path("/products/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDTO productDTO) {
        Product product = productDTO.toProduct();
        warehouse.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }


}