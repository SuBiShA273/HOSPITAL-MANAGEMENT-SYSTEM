package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Doctor;
import com.examly.springapp.model.MedicalRecord;
import com.examly.springapp.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord medicalRecord) {
        MedicalRecord obj = medicalRecordService.create(medicalRecord);
        try
        {
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> getByPatientId(@PathVariable int id)
    {
        List<MedicalRecord> list=medicalRecordService.getByPatientId(id);
        if(list.isEmpty())
            return new ResponseEntity<>("No medical records found",HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getById(@PathVariable int id)
    {
        Optional<MedicalRecord> obj=medicalRecordService.getById(id);
        if(obj.isPresent())
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> update(@PathVariable int id, @RequestBody MedicalRecord mobj) {
        MedicalRecord updatedRecord = medicalRecordService.update(id, mobj);

        if (updatedRecord != null) {
            return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}

}
