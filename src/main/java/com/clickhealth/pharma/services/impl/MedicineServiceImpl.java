package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.medicine.model.CreateMedicineRequest;
import com.clickhealth.pharma.medicine.model.Medicine;
import com.clickhealth.pharma.entity.MedicineEntity;
import com.clickhealth.pharma.mapper.MedicineMapper;
import com.clickhealth.pharma.repository.MedicineRepository;
import com.clickhealth.pharma.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    private static final Logger log = LoggerFactory.getLogger(MedicineServiceImpl.class);
    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll()
                .stream()
                .map(MedicineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Medicine getById(Integer id) {
        Optional<MedicineEntity> entity = medicineRepository.findById(id);
        return entity.map(MedicineMapper::toDto).orElse(null);
    }

    @Override
    public Medicine create(CreateMedicineRequest request) {
        MedicineEntity entity = MedicineMapper.toEntity(request);
        MedicineEntity saved = medicineRepository.save(entity);
        log.info("Created medicine: {}", saved.getName());
        return MedicineMapper.toDto(saved);
    }

    @Override
    public Medicine update(Integer id, CreateMedicineRequest request) {
        if (!medicineRepository.existsById(id)) {
            return null;
        }

        MedicineEntity entity = MedicineMapper.toEntity(request);
        entity.setId(id);

        MedicineEntity updated = medicineRepository.save(entity);
        log.info("Updated medicine ID {}: {}", id, updated.getName());
        return MedicineMapper.toDto(updated);
    }

    @Override
    public void delete(Integer id) {
        medicineRepository.deleteById(id);
        log.info("Deleted medicine ID {}", id);
    }
}
