package com.acme.customers.api.rest.v1.mappers;

import com.acme.customers.api.rest.v1.services.exceptions.GeneralServiceException;
import com.acme.customers.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.UUID;

public class GeneralMapper implements ExceptionMapper<GeneralServiceException> {

    @Override
    public Response toResponse(GeneralServiceException exception) {
        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(500);
        error.setCode("general.service.error");

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }

}
