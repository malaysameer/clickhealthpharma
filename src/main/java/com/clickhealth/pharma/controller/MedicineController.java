package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.medicine.api.MedicinesApi;
import com.clickhealth.pharma.medicine.model.CreateMedicineRequest;
import com.clickhealth.pharma.medicine.model.Medicine;
import com.clickhealth.pharma.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class MedicineController implements MedicinesApi {

    private static final Logger log = LoggerFactory.getLogger(MedicineController.class);

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @Override
    public ResponseEntity<List<Medicine>> listMedicines() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    @Override
    public ResponseEntity<Void> addMedicine(@Valid CreateMedicineRequest medicine) {
        medicineService.create(medicine);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Medicine> getMedicineById(Integer id) {
        Medicine medicine = medicineService.getById(id);
        if (medicine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medicine);
    }

    @Override
    public ResponseEntity<Void> updateMedicine(Integer id, @Valid CreateMedicineRequest medicine) {
        medicineService.update(id, medicine);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMedicine(Integer id) {
        medicineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
