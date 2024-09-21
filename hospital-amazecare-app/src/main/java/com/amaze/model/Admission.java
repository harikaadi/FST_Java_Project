package com.amaze.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private InPatient patient; // The patient being admitted

    @ManyToOne
    private Doctor doctor; // The doctor assigned to the patient

    @ManyToOne
    private Room room; // The room allocated to the patient

    private String admissionType; // e.g., General, Surgery
    
    private LocalDate admissionDate; // Date of admission

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InPatient getPatient() {
		return patient;
	}

	public void setPatient(InPatient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	
    
	

    // Getters and Setters
}
