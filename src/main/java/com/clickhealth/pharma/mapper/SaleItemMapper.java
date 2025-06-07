package com.clickhealth.pharma.mapper;


import com.clickhealth.pharma.entity.SaleItemEntity;
import com.clickhealth.pharma.sales.model.CreateSaleItemRequest;
import com.clickhealth.pharma.sales.model.SaleItem;

public class SaleItemMapper {

    public static SaleItem toDto(SaleItemEntity entity) {
        if (entity == null) return null;

        return new SaleItem()
                .medicineId(entity.getMedicineId())
                .quantity(entity.getQuantity())
                .price(entity.getPrice());
    }

    public static SaleItemEntity toEntity(CreateSaleItemRequest request) {
        if (request == null) return null;

        return SaleItemEntity.builder()
                .medicineId(request.getMedicineId())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .build();
    }
}
