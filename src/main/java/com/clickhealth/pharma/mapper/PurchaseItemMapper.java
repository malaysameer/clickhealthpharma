package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.PurchaseItemEntity;
import com.clickhealth.pharma.purchase.model.CreatePurchaseItemRequest;
import com.clickhealth.pharma.purchase.model.PurchaseItem;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class PurchaseItemMapper {

    public static PurchaseItem toDto(PurchaseItemEntity entity) {
        if (entity == null) return null;

        return new PurchaseItem(
                entity.getMedicineId(),
                entity.getQuantity(),
                entity.getCost()
        )
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }


    public static PurchaseItemEntity toEntity(CreatePurchaseItemRequest request) {
        if (request == null) return null;

        return PurchaseItemEntity.builder()
                .medicineId(request.getMedicineId())
                .quantity(request.getQuantity())
                .cost(request.getCost())
                .build();
    }
}
