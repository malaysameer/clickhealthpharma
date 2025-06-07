package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.sales.api.SalesApi;
import com.clickhealth.pharma.sales.model.CreateSaleRequest;
import com.clickhealth.pharma.sales.model.Sale;
import com.clickhealth.pharma.services.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class SalesController implements SalesApi {

    private static final Logger log = LoggerFactory.getLogger(SalesController.class);

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public ResponseEntity<List<Sale>> listSales() {
        return ResponseEntity.ok(salesService.getAll());
    }

    @Override
    public ResponseEntity<Void> createSale(@Valid CreateSaleRequest sale) {
        salesService.create(sale);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Sale> getSaleById(Integer id) {
        Sale sale = salesService.getById(id);
        if (sale == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale);
    }
}
