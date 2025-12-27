package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.MedicalRecord;

public interface MedicalRecordService {
    MedicalRecord create(MedicalRecord medicalRecord);

    List<MedicalRecord> getByPatientId(int id);
    
    Optional<MedicalRecord> getById(int id);

    MedicalRecord update(int id,MedicalRecord mobj);
}
