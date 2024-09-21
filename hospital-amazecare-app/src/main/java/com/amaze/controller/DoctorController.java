package com.amaze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amaze.dto.MessageDto;
import com.amaze.exception.InvalidSpecializationException;
import com.amaze.exception.NoDoctorsAvailableException;
import com.amaze.model.Doctor;
import com.amaze.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor, MessageDto messageDto) {
        try {
            Doctor savedDoctor = doctorService.addDoctor(doctor);
            return ResponseEntity.ok(savedDoctor);
        } catch (Exception e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> getDoctorsBySpecialization(@PathVariable String specialization, MessageDto messageDto) {
    	System.out.println("inside /doctor/specialization/Cardiology");
        try {
            List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
            return ResponseEntity.ok(doctors);
        } catch (InvalidSpecializationException e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }

    @GetMapping("/available")
    public ResponseEntity<?> getAvailableDoctors(MessageDto messageDto) {
    	System.out.println("inside avalible");
        try {
            List<Doctor> doctors = doctorService.getAvailableDoctors();
            return ResponseEntity.ok(doctors);
        } catch (NoDoctorsAvailableException e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }
	
	

}
