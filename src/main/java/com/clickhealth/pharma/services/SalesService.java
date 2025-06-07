package com.clickhealth.pharma.services;

import com.clickhealth.pharma.sales.model.CreateSaleRequest;
import com.clickhealth.pharma.sales.model.Sale;

import java.util.List;

public interface SalesService {
    List<Sale> getAll();

    Sale getById(Integer id);

    Sale create(CreateSaleRequest request);
}
