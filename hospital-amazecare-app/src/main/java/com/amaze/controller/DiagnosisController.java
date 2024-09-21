package com.amaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amaze.dto.MessageDto;
import com.amaze.exception.InvalidAdmissionId;
import com.amaze.model.Diagnosis;
import com.amaze.service.DiagnosisService;

@Controller
public class DiagnosisController {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@PostMapping("/diagnosis/add/{AdmissionId}")
	public ResponseEntity<?> addDiagnosis(@RequestBody Diagnosis diagnosis,@PathVariable int AdmissionId,MessageDto messgaedto) {
		
		 try {
			diagnosis = diagnosisService.addDiagnosis(diagnosis,AdmissionId);
		 return ResponseEntity.ok().body(diagnosis);
		} catch (InvalidAdmissionId e) {
			
			//e.printStackTrace();
			messgaedto.setMsg(e.getMeassage());
			return ResponseEntity.badRequest().body(messgaedto);
		}
		
	}

}
