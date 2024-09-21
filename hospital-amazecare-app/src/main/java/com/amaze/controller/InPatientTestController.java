package com.amaze.controller;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amaze.dto.MessageDto;
import com.amaze.exception.InvalidIdException;
import com.amaze.model.InPatientTest;
import com.amaze.service.InPatientTestService;

@Controller
public class InPatientTestController {
	
	@Autowired
	private InPatientTestService inpatienttestservice;
	
	@PostMapping("/inpatient-test/add/{patientid}/{doctorid}/{testid}")
	public ResponseEntity<?> AssignTesttoPatient(@PathVariable int patientid,@PathVariable int doctorid,@PathVariable int testid,MessageDto messagedto) {
		
		try {
			InPatientTest inpatienttest = inpatienttestservice.AssignTesttoPatient(patientid,doctorid,testid);
			return ResponseEntity.ok(inpatienttest);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			messagedto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(messagedto);
		}
		
	}
	
	/*@GetMapping("/gettest/{patinetid}")
	public ResponseEntity<?> getTestbyInpatientID(@PathVariable int patinetid,Message messagedto) {
		
		try {
			List<InPatientTest>  inpatienttest= inpatienttestservice.getTestbyInpatientID(patinetid);
			return ResponseEntity.ok(inpatienttest);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			messagedto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(messagedto);
		}
		
	}*/

}
