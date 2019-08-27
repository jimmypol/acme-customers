package com.acme.customers.api.rest.v1.resources;

import com.acme.customers.api.rest.v1.services.CustomerService;
import com.acme.customers.lib.v1.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    public Response getCustomers(@QueryParam("limit") Integer limit,
                                 @QueryParam("offset") Integer offset) throws SQLException {

        return Response.ok(customerService.findCustomers(limit, offset)).header("X-Total-Count", 0).build();

    }

    @POST
    public Response createCustomer(Customer newCustomer) throws SQLException {

        return Response.ok(customerService.createCustomer(newCustomer)).build();

    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id) throws SQLException {

        return Response.ok(customerService.findCustomerById(id)).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") String id) throws SQLException {

        customerService.deleteCustomer(id);

        return Response.noContent().build();

    }
}
