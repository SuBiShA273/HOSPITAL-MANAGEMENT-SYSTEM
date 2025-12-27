package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.MedicalRecord;
import com.examly.springapp.repository.MedicalRecordRepository;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Override
    public MedicalRecord create(MedicalRecord medicalRecord)
    {
        return medicalRecordRepository.save(medicalRecord);
    }
    @Override
    public List<MedicalRecord> getByPatientId(int id)
    {
        return medicalRecordRepository.findByPatientId(id);
    }
    @Override
    public Optional<MedicalRecord> getById(int id)
    {
        return medicalRecordRepository.findById(id);
    }
    @Override
    public MedicalRecord update(int id, MedicalRecord mobj) {
    Optional<MedicalRecord> existingRecordOpt = medicalRecordRepository.findById(id);

    if (existingRecordOpt.isPresent()) {
        MedicalRecord existingRecord = existingRecordOpt.get();
        existingRecord.setDiagnosis(mobj.getDiagnosis());
        existingRecord.setPrescription(mobj.getPrescription());
        existingRecord.setPatient(mobj.getPatient());

        return medicalRecordRepository.save(existingRecord);
    }

    return null;
}

}
