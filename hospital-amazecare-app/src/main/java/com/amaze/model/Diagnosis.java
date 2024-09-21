package com.amaze.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Diagnosis {
	
		@Id()
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private int diagnosisId;
	    
		@ManyToOne
	    private Admission admission; // Link to Admission, which includes patient and doctor details
	    
	    private String symptoms;
	    
	    private String diagnosisDetails;
	    
	    private LocalDate diagnosisDate;

		public int getDiagnosisId() {
			return diagnosisId;
		}

		public void setDiagnosisId(int diagnosisId) {
			this.diagnosisId = diagnosisId;
		}

		public Admission getAdmission() {
			return admission;
		}

		public void setAdmission(Admission admission) {
			this.admission = admission;
		}

		public String getSymptoms() {
			return symptoms;
		}

		public void setSymptoms(String symptoms) {
			this.symptoms = symptoms;
		}

		public String getDiagnosisDetails() {
			return diagnosisDetails;
		}

		public void setDiagnosisDetails(String diagnosisDetails) {
			this.diagnosisDetails = diagnosisDetails;
		}

		public LocalDate getDiagnosisDate() {
			return diagnosisDate;
		}

		public void setDiagnosisDate(LocalDate localDate) {
			this.diagnosisDate = localDate;
		}

		
		
}
	



