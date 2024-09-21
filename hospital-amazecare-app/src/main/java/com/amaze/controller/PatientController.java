package com.amaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amaze.model.InPatient;
import com.amaze.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientservice;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<InPatient> addPatient(@RequestBody InPatient patient) {
		System.out.println("in controller");
		
				InPatient savedPatient=patientservice.addPatient(patient);
				 return ResponseEntity.ok(savedPatient);
	}
	/*@PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.registerPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }*/

}
