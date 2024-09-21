package com.amaze.dto;

import java.time.LocalDate;

public class TestResultAddDto {

	    
	    private String testDetails; // Detailed description of the test
	    
	    private String testResult; // Positive/Negative/Normal
	    
	    private String labName; 
	    
	    private LocalDate dateTestConducted; // Date the test was conducted
	    
	    private LocalDate dateTestResult;

		public String getTestDetails() {
			return testDetails;
		}

		public void setTestDetails(String testDetails) {
			this.testDetails = testDetails;
		}

		public String getTestResult() {
			return testResult;
		}

		public void setTestResult(String testResult) {
			this.testResult = testResult;
		}

		public String getLabName() {
			return labName;
		}

		public void setLabName(String labName) {
			this.labName = labName;
		}

		public LocalDate getDateTestConducted() {
			return dateTestConducted;
		}

		public void setDateTestConducted(LocalDate dateTestConducted) {
			this.dateTestConducted = dateTestConducted;
		}

		public LocalDate getDateTestResult() {
			return dateTestResult;
		}

		public void setDateTestResult(LocalDate dateTestResult) {
			this.dateTestResult = dateTestResult;
		}
}
