package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.PurchaseEntity;
import com.clickhealth.pharma.purchase.model.CreatePurchaseRequest;
import com.clickhealth.pharma.purchase.model.Purchase;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class PurchaseMapper {

    public static Purchase toDto(PurchaseEntity entity) {
        if (entity == null) return null;

        return new Purchase()
                .id(entity.getId())
                .supplierId(entity.getSupplierId())
                .purchaseDate(DateTimeUtils.toOffsetDateTime(entity.getPurchaseDate()))
                .totalAmount(entity.getTotalAmount())
                .items(entity.getItems().stream().map(PurchaseItemMapper::toDto).toList())
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }

    public static PurchaseEntity toEntity(CreatePurchaseRequest request) {
        if (request == null) return null;

        var entity = PurchaseEntity.builder()
                .supplierId(request.getSupplierId())
                .purchaseDate(DateTimeUtils.toLocalDateTime(request.getPurchaseDate()))
                .totalAmount(request.getTotalAmount())
                .build();

        entity.setItems(request.getItems().stream()
                .map(PurchaseItemMapper::toEntity)
                .peek(item -> item.setPurchase(entity))
                .toList());

        return entity;
    }
}

