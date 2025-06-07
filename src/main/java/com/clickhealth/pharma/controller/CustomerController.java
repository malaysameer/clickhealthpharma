package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.customer.api.CustomersApi;
import com.clickhealth.pharma.customer.model.CreateCustomerRequest;
import com.clickhealth.pharma.customer.model.Customer;
import com.clickhealth.pharma.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class CustomerController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers() {
        log.info("Request recieved to fetch complete customer list");
        return ResponseEntity.ok(customerService.getAll());
    }

    @Override
    public ResponseEntity<Void> addCustomer(@Valid CreateCustomerRequest customer) {
        customerService.create(customer);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Integer id) {
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<Void> updateCustomer(Integer id, @Valid CreateCustomerRequest customer) {
        customerService.update(id, customer);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
