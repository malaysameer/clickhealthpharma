package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.supplier.model.CreateSupplierRequest;
import com.clickhealth.pharma.supplier.model.Supplier;
import com.clickhealth.pharma.entity.SupplierEntity;
import com.clickhealth.pharma.mapper.SupplierMapper;
import com.clickhealth.pharma.repository.SupplierRepository;
import com.clickhealth.pharma.services.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final Logger log = LoggerFactory.getLogger(SupplierServiceImpl.class);
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Supplier getById(Integer id) {
        Optional<SupplierEntity> entity = supplierRepository.findById(id);
        return entity.map(SupplierMapper::toDto).orElse(null);
    }

    @Override
    public Supplier create(CreateSupplierRequest request) {
        SupplierEntity entity = SupplierMapper.toEntity(request);
        SupplierEntity saved = supplierRepository.save(entity);
        log.info("Created supplier: {}", saved.getName());
        return SupplierMapper.toDto(saved);
    }

    @Override
    public Supplier update(Integer id, CreateSupplierRequest request) {
        if (!supplierRepository.existsById(id)) {
            return null;
        }

        SupplierEntity entity = SupplierMapper.toEntity(request);
        entity.setId(id);

        SupplierEntity updated = supplierRepository.save(entity);
        log.info("Updated supplier ID {}: {}", id, updated.getName());
        return SupplierMapper.toDto(updated);
    }

    @Override
    public void delete(Integer id) {
        supplierRepository.deleteById(id);
        log.info("Deleted supplier ID {}", id);
    }
}
