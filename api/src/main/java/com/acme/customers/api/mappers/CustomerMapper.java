package com.acme.customers.api.mappers;

import com.acme.customers.api.models.db.CustomerEntity;
import com.acme.customers.lib.v1.Customer;

public class CustomerMapper {

    public static Customer toCustomer(CustomerEntity customerEntity) {

        if (customerEntity == null) return null;

        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setStatus(customerEntity.getStatus());
        customer.setDateOfBirth(customerEntity.getDateOfBirth());
        customer.setCreatedAt(customerEntity.getCreatedAt());
        customer.setUpdatedAt(customerEntity.getUpdatedAt());

        return customer;
    }

    public static CustomerEntity toCustomerEntity(Customer customer) {

        if (customer == null) return null;

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setStatus(customer.getStatus());
        customerEntity.setDateOfBirth(customer.getDateOfBirth());

        return customerEntity;
    }
}
