package com.streams.resources;

import com.streams.entities.Category;
import com.streams.entities.Product;

import com.streams.service.WarehouseService;
import jakarta.validation.Valid;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/")
@Log
public class WarehouseResource {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseResource.class);

    private WarehouseService warehouseService;

    public WarehouseResource() {
    }

    @Inject
    public WarehouseResource(@Named("Impl") WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return warehouseService.getProducts();
    }

    @Path("/products/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") String id) {
        return warehouseService.getProductsById(Integer.parseInt(id));
    }

    @Path("/products/category/{category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByCategory(@PathParam("category") String categoryString) {
        Category category = Category.valueOf(categoryString.toUpperCase());
        return warehouseService.getProductsByCategory(category);
    }

    @POST
    @Path("/products/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createProduct(@Valid ProductDTO productDTO) {
        Product product = productDTO.toProduct();
        warehouseService.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }


}