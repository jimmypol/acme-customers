package com.acme.customers.api.rest.v1.services.exceptions;

public class EmptyPayloadException extends RuntimeException {

    private String resource;

    public EmptyPayloadException(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
