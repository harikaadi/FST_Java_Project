package com.amaze.model;

import com.amaze.enums.DoctorType;
import com.amaze.enums.Specialization;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String name;
    
	@Enumerated(EnumType.STRING)
    private Specialization specialization;

    private Boolean available;
    
   @Enumerated(EnumType.STRING)
    private DoctorType doctortype;//doctorType

    @OneToOne
    private UserInfo user;
    
    //private String experience;
    //private String qualification;
    //private String designation;
    
   
	public int getId() {
		
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public DoctorType getDoctortype() {
		return doctortype;
	}

	public void setDoctortype(DoctorType doctortype) {
		this.doctortype = doctortype;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	

}
