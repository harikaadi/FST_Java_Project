package com.amaze.controller;


import java.io.FileOutputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amaze.dto.MessageDto;
import com.amaze.exception.InvalidIdException;
import com.amaze.model.InpatientTestResult;
import com.amaze.service.InpatientTestResultService;



@RestController
public class InpatientTestResultController {
	
	@Autowired
	private InpatientTestResultService inpatientTestResultService;
	
	@PostMapping("/testresult/add/{inpatienttestid}")
	public ResponseEntity<?> addTestResult(@RequestBody MultipartFile file,@PathVariable int inpatienttestid,MessageDto mesagedto) throws IOException {
		System.out.println("inside addtestresult method");
		
		try {
			InpatientTestResult uplodedtest= inpatientTestResultService.addTestResult(file,inpatienttestid);
			return ResponseEntity.ok(uplodedtest);
		} catch (IOException e) {
			mesagedto.setMsg(e.getMessage());
		return ResponseEntity.badRequest().body(mesagedto);
			
		} catch (InvalidIdException e) {
			mesagedto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(mesagedto);
				
		}
		
			//amaze-hospital-app/src/main/resources/static/Images
			//System.out.println("File "+file.getOriginalFilename()+"uploaded"+"with size"+file.getBytes());
			//C:\Users\Harika Adi\Desktop\A\hospital-amazecare-app\src\main\resources\static\Images
		//C:\Users\Harika Adi\Desktop\A\hospital-amazecare-app\src\main\resources\static\Images
		//String filename = file.getOriginalFilename();
		//FileOutputStream fos = FileOutputStream("C:/Users/Harika Adi/Desktop/A/hospital-amazecare-app/src/main/resources/static/Images"+filename);
		
		
		/*String filename = file.getOriginalFilename();
		FileOutputStream fos = new FileOutputStream("C:/Users/Harika Adi/Desktop/A/hospital-amazecare-app/src/main/resources/static/Images/" + filename);
        //save this in the DB
		
		InputStream is= file.getInputStream();
           byte[] byt=new byte[is.available()];
           is.read(byt);
           fos.write(byt);
           fos.close();*/

		
	}

	

}
