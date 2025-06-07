package com.clickhealth.pharma.repository;

import com.clickhealth.pharma.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {
    // You can add custom query methods here
}
