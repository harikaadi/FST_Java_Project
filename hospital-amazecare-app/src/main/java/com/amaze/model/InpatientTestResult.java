package com.amaze.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
//import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InpatientTestResult {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    @ManyToOne
	    //@JoinColumn(name = "inpatient_test_id", nullable = false)
	    private InPatientTest inPatientTest;

	    @Column(nullable = false)
	    private String fileName;
	    
	    @Column(length = 1000)
	    private String filePath;

	    private LocalDate uploadedAt;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public InPatientTest getInPatientTest() {
			return inPatientTest;
		}

		public void setInPatientTest(InPatientTest inPatientTest) {
			this.inPatientTest = inPatientTest;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public LocalDate getUploadedAt() {
			return uploadedAt;
		}

		public void setUploadedAt(LocalDate uploadedAt) {
			this.uploadedAt = uploadedAt;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		

	    // Constructors, Getters, Setters
	


}
