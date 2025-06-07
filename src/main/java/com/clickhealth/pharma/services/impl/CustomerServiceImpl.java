package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.customer.model.CreateCustomerRequest;
import com.clickhealth.pharma.customer.model.Customer;
import com.clickhealth.pharma.entity.CustomerEntity;
import com.clickhealth.pharma.mapper.CustomerMapper;
import com.clickhealth.pharma.repository.CustomerRepository;
import com.clickhealth.pharma.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(Integer id) {
        Optional<CustomerEntity> entity = customerRepository.findById(id);
        return entity.map(CustomerMapper::toDto).orElse(null);
    }

    @Override
    public Customer create(CreateCustomerRequest request) {
        CustomerEntity entity = CustomerMapper.toEntity(request);
        CustomerEntity saved = customerRepository.save(entity);
        log.info("Created customer: {}", saved.getName());
        return CustomerMapper.toDto(saved);
    }

    @Override
    public Customer update(Integer id, CreateCustomerRequest request) {
        if (!customerRepository.existsById(id)) {
            return null;
        }

        CustomerEntity entity = CustomerMapper.toEntity(request);
        entity.setId(id);

        CustomerEntity updated = customerRepository.save(entity);
        log.info("Updated customer ID {}: {}", id, updated.getName());
        return CustomerMapper.toDto(updated);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
        log.info("Deleted customer ID {}", id);
    }
}
