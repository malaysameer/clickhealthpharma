package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.customer.model.Customer;
import com.clickhealth.pharma.customer.model.CreateCustomerRequest;
import com.clickhealth.pharma.entity.CustomerEntity;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class CustomerMapper {

    // Map from Entity to API Response DTO
    public static Customer toDto(CustomerEntity entity) {
        if (entity == null) return null;

        return new Customer()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }

    // Map from API Request DTO to Entity (CREATE)
    public static CustomerEntity toEntity(CreateCustomerRequest request) {
        if (request == null) return null;

        return CustomerEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
    }
}
