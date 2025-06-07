package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.entity.SaleEntity;
import com.clickhealth.pharma.mapper.SaleMapper;
import com.clickhealth.pharma.repository.SaleRepository;
import com.clickhealth.pharma.sales.model.CreateSaleRequest;
import com.clickhealth.pharma.sales.model.Sale;
import com.clickhealth.pharma.services.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {

    private static final Logger log = LoggerFactory.getLogger(SalesServiceImpl.class);
    private final SaleRepository saleRepository;

    public SalesServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll()
                .stream()
                .map(SaleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Sale getById(Integer id) {
        Optional<SaleEntity> entity = saleRepository.findById(id);
        return entity.map(SaleMapper::toDto).orElse(null);
    }

    @Override
    public Sale create(CreateSaleRequest request) {
        SaleEntity entity = SaleMapper.toEntity(request);

        double total = entity.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        entity.setTotalAmount(total);

        SaleEntity saved = saleRepository.save(entity);
        log.info("Recorded sale for customer ID {}", saved.getCustomerId());
        return SaleMapper.toDto(saved);
    }
}
