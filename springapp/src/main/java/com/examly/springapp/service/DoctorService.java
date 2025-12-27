package com.examly.springapp.service;

import com.examly.springapp.model.Doctor;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(int id);
    Doctor updateDoctor(int id, Doctor doctor);
    void deleteById(int id);
    Page<Doctor> getDoctors(int pageno,int pagesize);
}
