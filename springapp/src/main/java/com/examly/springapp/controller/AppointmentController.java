package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Appointment;
import com.examly.springapp.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    
    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        Appointment obj = appointmentService.create(appointment);
        try
        {
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getByStatus(@PathVariable String status)
    {
        List<Appointment> obj=appointmentService.getByStatus(status);
        if(!obj.isEmpty())
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id)
    {
        Optional<Appointment> obj=appointmentService.getById(id);
        if(obj.isPresent())
            return new ResponseEntity<>(obj.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id,@RequestBody Appointment appointment)
    {
        Appointment obj=appointmentService.update(id,appointment);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
