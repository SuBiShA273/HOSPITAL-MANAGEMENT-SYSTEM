package com.examly.springapp.service;

import java.util.Optional;

import com.examly.springapp.model.Patient;

public interface PatientService {
    Patient create(Patient patient);
    Optional<Patient> getPatientById(int id);
    Patient updatePatient(int id,Patient patient);
}
