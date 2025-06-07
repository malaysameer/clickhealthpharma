package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.purchase.api.PurchasesApi;
import com.clickhealth.pharma.purchase.model.CreatePurchaseRequest;
import com.clickhealth.pharma.purchase.model.Purchase;
import com.clickhealth.pharma.services.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class PurchaseController implements PurchasesApi {

    private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public ResponseEntity<List<Purchase>> listPurchases() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @Override
    public ResponseEntity<Void> createPurchase(@Valid CreatePurchaseRequest purchase) {
        purchaseService.create(purchase);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Purchase> getPurchaseById(Integer id) {
        Purchase purchase = purchaseService.getById(id);
        if (purchase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(purchase);
    }
}
