package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.SaleEntity;
import com.clickhealth.pharma.sales.model.CreateSaleRequest;
import com.clickhealth.pharma.sales.model.Sale;
import com.clickhealth.pharma.utils.DateTimeUtils;


public class SaleMapper {

    public static Sale toDto(SaleEntity entity) {
        if (entity == null) return null;

        return new Sale()
                .id(entity.getId())
                .customerId(entity.getCustomerId())
                .saleDate(entity.getSaleDate())
                .totalAmount(entity.getTotalAmount())
                .items(entity.getItems().stream().map(SaleItemMapper::toDto).toList())
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }

    public static SaleEntity toEntity(CreateSaleRequest request) {
        if (request == null) return null;

        var entity = SaleEntity.builder()
                .customerId(request.getCustomerId())
                .saleDate(request.getSaleDate())
                .totalAmount(request.getTotalAmount())
                .build();

        entity.setItems(request.getItems().stream()
                .map(SaleItemMapper::toEntity)
                .peek(item -> item.setSale(entity))
                .toList());

        return entity;
    }
}
