package com.examly.springapp.service;

import com.examly.springapp.model.Doctor;
import com.examly.springapp.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor updateDoctor(int id, Doctor doctorDetails) {
        Doctor existingDoctor = doctorRepository.findById(id).orElse(null);

        if (existingDoctor != null) {
        existingDoctor.setName(doctorDetails.getName());
        existingDoctor.setSpecialization(doctorDetails.getSpecialization());
        existingDoctor.setContactNumber(doctorDetails.getContactNumber());
        existingDoctor.setRoomNumber(doctorDetails.getRoomNumber());
        return doctorRepository.save(existingDoctor);
    }

    return null;
}
    @Override
    public void deleteById(int id)
    {
        doctorRepository.deleteById(id);
    }

    @Override
    public Page<Doctor> getDoctors(int pageno,int pagesize)
    {
        Pageable pageable=PageRequest.of(pageno, pagesize);
        return doctorRepository.findAll(pageable);
    }
}
