package com.amaze.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amaze.exception.InvalidIdException;
import com.amaze.model.InPatientTest;
import com.amaze.model.InpatientTestResult;
import com.amaze.repo.InPatientTestRepo;
import com.amaze.repo.InpatientTestResultRepo;

@Service
public class InpatientTestResultService {
	
	@Autowired
	private InpatientTestResultRepo inpatienttestresultrepo;
	
	@Autowired
	private InPatientTestRepo inpatienttestrepo;

	public InpatientTestResult addTestResult(MultipartFile file, int inpatienttestid) throws IOException, InvalidIdException {
		
		
		//fetching the inpatienttest by id 
		Optional<InPatientTest>  optionalinpatienttest= inpatienttestrepo.findById(inpatienttestid);
		if(optionalinpatienttest.isEmpty()) {
			throw new InvalidIdException("invalid inpatient-testid ");
		}
		InPatientTest inpatienttest = optionalinpatienttest.get();
		
		//saving this inpatienttest into inpatientresult
		InpatientTestResult inpatinettestresult = new InpatientTestResult();
		
		inpatinettestresult.setInPatientTest(inpatienttest);
		
		String filename = file.getOriginalFilename();
		//creating new file
		File destinationfile = new File("C:/Users/Harika Adi/Desktop/A/hospital-amazecare-app/src/main/resources/static/Images/" + filename);
		//creating new filestream
		FileOutputStream fos = new FileOutputStream("C:/Users/Harika Adi/Desktop/A/hospital-amazecare-app/src/main/resources/static/Images/" + filename);
        //save this in the DB
		
		InputStream is= file.getInputStream();
           byte[] byt=new byte[is.available()];
           is.read(byt);
           fos.write(byt);
           fos.close();
           
           inpatinettestresult.setFileName(filename);
           inpatinettestresult.setFilePath(destinationfile.getAbsolutePath());
           inpatinettestresult.setUploadedAt(LocalDate.now());
           return inpatienttestresultrepo.save(inpatinettestresult);
           
		
	}

}
