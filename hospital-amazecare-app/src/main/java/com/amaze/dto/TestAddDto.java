package com.amaze.dto;

import java.time.LocalDate;

public class TestAddDto {
	
	 private String testName;
	
	 private LocalDate dateTestGivenByDoctor;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalDate getDateTestGivenByDoctor() {
		return dateTestGivenByDoctor;
	}

	public void setDateTestGivenByDoctor(LocalDate dateTestGivenByDoctor) {
		this.dateTestGivenByDoctor = dateTestGivenByDoctor;
	}

}
