package com.examly.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Doctor;
import com.examly.springapp.model.MedicalRecord;
import com.examly.springapp.model.Patient;
import com.examly.springapp.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        try
        {
            Patient obj = patientService.create(patient);
            return new ResponseEntity<>(obj,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id)
    {
        Optional<Patient> obj=patientService.getPatientById(id);
        if(obj.isPresent())
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patient)
    {
        Patient obj=patientService.updatePatient(id,patient);
        if(obj==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
