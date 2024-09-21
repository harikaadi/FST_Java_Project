package com.amaze.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaze.exception.InvalidIdException;
import com.amaze.model.Doctor;
import com.amaze.model.InPatient;
import com.amaze.model.InPatientTest;
import com.amaze.model.Test;
import com.amaze.repo.DoctorRepository;
import com.amaze.repo.InPatientTestRepo;
import com.amaze.repo.PatientRepo;
import com.amaze.repo.Test_InPRepo;

@Service
public class InPatientTestService {
	
	
	@Autowired
	private InPatientTestRepo inpatienttestrepo;
	
	@Autowired
	private Test_InPRepo testinprepo;
	
	@Autowired
	private PatientRepo inpatientrepo;
	
	@Autowired
	private DoctorRepository doctorrepo;
	
	public InPatientTest AssignTesttoPatient(int patientid, int doctorid, int testid) throws InvalidIdException {
	
		
		 Optional<InPatient>optionalpatient = inpatientrepo.findById(patientid);
		 if(optionalpatient.isEmpty()) {
			throw new  InvalidIdException("Invalid patient id");
		 }
		 InPatient inpatient = optionalpatient.get();
		 
		 Optional<Doctor>optionaldoctor = doctorrepo.findById(doctorid);
		 if(optionaldoctor.isEmpty()) {
			throw new  InvalidIdException("Invalid doctor id");
		 }
		 Doctor doctor = optionaldoctor .get();
		 
		 
		 Optional<Test>optionaltest = testinprepo.findById(testid);
		 if(optionaltest.isEmpty()) {
			throw new  InvalidIdException("Invalid patient id");
		 }
		Test test = optionaltest.get();
		
		InPatientTest inpatienttest = new InPatientTest();
		
		inpatienttest.setInpatient(inpatient);
		inpatienttest.setDoctor(doctor);
		inpatienttest.setTest(test);
		inpatienttest.setDate(LocalDate.now());
		
		return inpatienttestrepo.save(inpatienttest);
		
		
	}

	public List<InPatientTest> getTestbyInpatientID(int patinetid) throws InvalidIdException {
		
		
		// TODO Auto-generated method stub
		 List<InPatientTest>  patinettest= inpatienttestrepo.findinpatinettest(patinetid);
		 return patinettest;
		
	
	}
	

}
