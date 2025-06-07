package com.clickhealth.pharma.services;

import com.clickhealth.pharma.purchase.model.CreatePurchaseRequest;
import com.clickhealth.pharma.purchase.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAll();

    Purchase getById(Integer id);

    Purchase create(CreatePurchaseRequest request);
}
