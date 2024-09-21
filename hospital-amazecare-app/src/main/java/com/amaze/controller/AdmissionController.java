package com.amaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amaze.dto.AdmissionRequestDto;
import com.amaze.dto.AdmissionResponseDto;
import com.amaze.dto.MessageDto;
import com.amaze.enums.CommonHealthIssues;
import com.amaze.enums.RoomType;
import com.amaze.exception.AdmissionNotAvaliableException;
import com.amaze.exception.InvalidIdException;
import com.amaze.exception.NoRoomsAvailableException;
import com.amaze.model.Admission;
import com.amaze.service.AdmissionService;

@Controller
public class AdmissionController {
	
	@Autowired
	private AdmissionService admissionservice;
	
	
	@PostMapping("addadmission/{patientid}/{issueName}/{roomtype}")
	public ResponseEntity<?> addAdmission(@PathVariable int patientid,@PathVariable CommonHealthIssues issueName, @PathVariable RoomType roomtype,@RequestBody Admission admission,MessageDto messagedto) {
		System.out.println("inside add_admission controller");
		try {
			admission = admissionservice.addAdmission(patientid,issueName,roomtype,admission);
			return ResponseEntity.ok(admission); 
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage()); 
			//e.printStackTrace();
		} catch (NoRoomsAvailableException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage()); 
			//e.printStackTrace();
		}	
	}
	 

}
