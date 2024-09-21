package com.amaze.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaze.exception.InvalidAdmissionId;
import com.amaze.model.Admission;
import com.amaze.model.Diagnosis;
import com.amaze.repo.AdmissionRepo;
import com.amaze.repo.DiagnosisRepo;

@Service
public class DiagnosisService {
	
	@Autowired
	private DiagnosisRepo  diagnosisrepo;
	
	@Autowired
	private AdmissionRepo admissionrepo;

	public Diagnosis addDiagnosis(Diagnosis diagnosis, int admissionId) throws InvalidAdmissionId {
		
		Optional<Admission> optionaladmission = admissionrepo.findById(admissionId);
		if(optionaladmission.isEmpty()) {
			throw new InvalidAdmissionId("Invalid Admission ID");
		}
		Admission admission = optionaladmission.get();
		diagnosis.setAdmission(admission);
		
		diagnosis.setDiagnosisDate(LocalDate.now());
		
		return diagnosisrepo.save(diagnosis);
		
	}

}
