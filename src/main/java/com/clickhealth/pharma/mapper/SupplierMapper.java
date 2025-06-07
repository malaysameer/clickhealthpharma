package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.SupplierEntity;
import com.clickhealth.pharma.supplier.model.CreateSupplierRequest;
import com.clickhealth.pharma.supplier.model.Supplier;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class SupplierMapper {

    public static Supplier toDto(SupplierEntity entity) {
        if (entity == null) return null;

        return new Supplier()
                .id(entity.getId())
                .name(entity.getName())
                .contactEmail(entity.getContactEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }

    public static SupplierEntity toEntity(CreateSupplierRequest request) {
        if (request == null) return null;

        return SupplierEntity.builder()
                .name(request.getName())
                .contactEmail(request.getContactEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
    }
}
