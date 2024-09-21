package com.amaze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amaze.model.InPatient;
import com.amaze.model.UserInfo;
import com.amaze.repo.PatientRepo;
import com.amaze.repo.UserRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo patinetrepo;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private UserRepository userrepositary;

	public InPatient addPatient(InPatient patient) {
		// TODO Auto-generated method stub
		System.out.println("in addPatinet");
		System.out.println(patient);
		
		       //detach user info from patient
				UserInfo user=patient.getUser();
				
				System.out.println(user);
				
				
				user.setRole("ROLE_PATIENT");
				
				user.setPassword(passwordencoder.encode(user.getPassword()));
				
				user = userrepositary.save(user);
				
				//attaching user to employee
				patient.setUser(user);
		
				return patinetrepo.save(patient);
						
	}

}
