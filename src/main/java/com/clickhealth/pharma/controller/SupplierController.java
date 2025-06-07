package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.supplier.api.SuppliersApi;
import com.clickhealth.pharma.supplier.model.CreateSupplierRequest;
import com.clickhealth.pharma.supplier.model.Supplier;
import com.clickhealth.pharma.services.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class SupplierController implements SuppliersApi {

    private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public ResponseEntity<List<Supplier>> listSuppliers() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @Override
    public ResponseEntity<Void> addSupplier(@Valid CreateSupplierRequest supplier) {
        supplierService.create(supplier);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Supplier> getSupplierById(Integer id) {
        Supplier supplier = supplierService.getById(id);
        if (supplier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supplier);
    }

    @Override
    public ResponseEntity<Void> updateSupplier(Integer id, @Valid CreateSupplierRequest supplier) {
        supplierService.update(id, supplier);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteSupplier(Integer id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
