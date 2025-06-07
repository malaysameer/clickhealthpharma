package com.clickhealth.pharma.services;

import com.clickhealth.pharma.medicine.model.CreateMedicineRequest;
import com.clickhealth.pharma.medicine.model.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> getAll();

    Medicine getById(Integer id);

    Medicine create(CreateMedicineRequest request);

    Medicine update(Integer id, CreateMedicineRequest request);

    void delete(Integer id);
}
