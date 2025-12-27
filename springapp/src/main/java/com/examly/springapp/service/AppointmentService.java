package com.examly.springapp.service;
import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Appointment;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    List<Appointment> getByStatus(String status);
    Optional<Appointment> getById(Long id);
    Appointment update(Long id,Appointment appointment);
}
