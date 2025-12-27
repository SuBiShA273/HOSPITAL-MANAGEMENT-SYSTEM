package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Appointment;
import com.examly.springapp.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired 
    AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment)
    {
        return appointmentRepository.save(appointment);
    }
    @Override
    public List<Appointment> getByStatus(String status)
    {
        return appointmentRepository.findByStatus(status);
    }
    @Override
    public Optional<Appointment> getById(Long id)
    {
        return appointmentRepository.findById(id);
    }
    @Override
    public Appointment update(Long id, Appointment appointmentDetails) {
    Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);

    if (existingAppointment != null) {
        existingAppointment.setStatus(appointmentDetails.getStatus());
        existingAppointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
        existingAppointment.setDoctor(appointmentDetails.getDoctor());
        existingAppointment.setPatient(appointmentDetails.getPatient());
		existingAppointment.setNotes(appointmentDetails.getNotes());
        return appointmentRepository.save(existingAppointment);
    }

    return null;
}


}
