package com.amaze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaze.model.Test;
import com.amaze.repo.Test_InPRepo;

@Service
public class Test_InPService {
	
	@Autowired
	private Test_InPRepo testinprepo;

	public Test addTest(Test testinp) {
		return testinprepo.save(testinp);
		
	}

}
