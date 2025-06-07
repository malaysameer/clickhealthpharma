package com.clickhealth.pharma.services;

import com.clickhealth.pharma.customer.model.CreateCustomerRequest;
import com.clickhealth.pharma.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer getById(Integer id);

    Customer create(CreateCustomerRequest request);

    Customer update(Integer id, CreateCustomerRequest request);

    void delete(Integer id);
}
