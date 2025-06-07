package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.MedicineEntity;
import com.clickhealth.pharma.medicine.model.CreateMedicineRequest;
import com.clickhealth.pharma.medicine.model.Medicine;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class MedicineMapper {

    public static Medicine toDto(MedicineEntity entity) {
        if (entity == null) return null;

        return new Medicine()
                .id(entity.getId())
                .name(entity.getName())
                .batchNumber(entity.getBatchNumber())
                .expiryDate(entity.getExpiryDate())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .supplierId(entity.getSupplierId())
                .createdAt(DateTimeUtils.toOffsetDateTime(entity.getCreatedAt()))
                .createdBy(entity.getCreatedBy())
                .updatedAt(DateTimeUtils.toOffsetDateTime(entity.getUpdatedAt()))
                .updatedBy(entity.getUpdatedBy());
    }

    public static MedicineEntity toEntity(CreateMedicineRequest request) {
        if (request == null) return null;

        return MedicineEntity.builder()
                .name(request.getName())
                .batchNumber(request.getBatchNumber())
                .expiryDate(request.getExpiryDate())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .supplierId(request.getSupplierId())
                .build();
    }
}
