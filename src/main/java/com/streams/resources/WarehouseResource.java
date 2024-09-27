package com.streams.resources;

import com.streams.service.Warehouse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class WarehouseResource {
    private Warehouse warehouse;

    public WarehouseResource() {}

    @Inject
    public WarehouseResource(Warehouse warehouse) {
        System.out.println("WarehouseResource object created");
        this.warehouse = warehouse;
    }

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}