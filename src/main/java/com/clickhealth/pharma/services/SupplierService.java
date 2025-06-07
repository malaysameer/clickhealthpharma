package com.clickhealth.pharma.services;

import com.clickhealth.pharma.supplier.model.CreateSupplierRequest;
import com.clickhealth.pharma.supplier.model.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> getAll();

    Supplier getById(Integer id);

    Supplier create(CreateSupplierRequest request);

    Supplier update(Integer id, CreateSupplierRequest request);

    void delete(Integer id);
}
