package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.entity.PurchaseEntity;
import com.clickhealth.pharma.mapper.PurchaseMapper;
import com.clickhealth.pharma.purchase.model.CreatePurchaseRequest;
import com.clickhealth.pharma.purchase.model.Purchase;
import com.clickhealth.pharma.repository.PurchaseRepository;
import com.clickhealth.pharma.services.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static final Logger log = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll()
                .stream()
                .map(PurchaseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Purchase getById(Integer id) {
        Optional<PurchaseEntity> entity = purchaseRepository.findById(id);
        return entity.map(PurchaseMapper::toDto).orElse(null);
    }

    @Override
    public Purchase create(CreatePurchaseRequest request) {
        PurchaseEntity entity = PurchaseMapper.toEntity(request);

        double total = entity.getItems().stream()
                .mapToDouble(item -> item.getCost() * item.getQuantity())
                .sum();
        entity.setTotalAmount(total);

        PurchaseEntity saved = purchaseRepository.save(entity);
        log.info("Recorded purchase from supplier ID {}", saved.getSupplierId());
        return PurchaseMapper.toDto(saved);
    }
}
