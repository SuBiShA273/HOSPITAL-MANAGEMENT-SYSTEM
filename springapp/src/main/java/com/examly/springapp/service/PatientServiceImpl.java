package com.examly.springapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Patient;
import com.examly.springapp.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient create(Patient patient)
    {
        return patientRepository.save(patient);
    }
    @Override
    public Optional<Patient> getPatientById(int id)
    {
        return patientRepository.findById(id);
    }
    @Override
    public Patient updatePatient(int id, Patient patientDetails) {
        Optional<Patient> existingPatientOpt = patientRepository.findById(id);

        if (existingPatientOpt.isPresent()) {
        Patient existingPatient = existingPatientOpt.get();
        existingPatient.setName(patientDetails.getName());
        existingPatient.setEmail(patientDetails.getEmail());
        existingPatient.setPhone(patientDetails.getPhone());
        existingPatient.setAddress(patientDetails.getAddress());
        existingPatient.setAge(patientDetails.getAge());

        return patientRepository.save(existingPatient);
        }
        return null;
}

}
