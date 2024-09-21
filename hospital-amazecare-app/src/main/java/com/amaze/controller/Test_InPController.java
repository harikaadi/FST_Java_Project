package com.amaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amaze.dto.MessageDto;
import com.amaze.model.Test;
import com.amaze.service.Test_InPService;

@Controller
public class Test_InPController {
	
	@Autowired
	private Test_InPService testinpservice;
	
	
	@PostMapping("/testinp/add")
	public ResponseEntity<?> addTest(@RequestBody Test testinp,MessageDto messageDto) {
		try {
		Test savedtestinp= testinpservice.addTest(testinp);
		 return ResponseEntity.ok(savedtestinp);
    } catch (Exception e) {
        messageDto.setMsg(e.getMessage());
        return ResponseEntity.badRequest().body(messageDto);
    }
		
	}
	
	

}
