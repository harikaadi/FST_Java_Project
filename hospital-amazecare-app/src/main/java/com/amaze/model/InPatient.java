package com.amaze.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class InPatient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int phonenumber;
	
	private String location;
	
	private Boolean ispatinentnew;
	
	@OneToOne
	private UserInfo user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getIspatinentnew() {
		return ispatinentnew;
	}

	public void setIspatinentnew(Boolean ispatinentnew) {
		this.ispatinentnew = ispatinentnew;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", location=" + location
				+ ", ispatinentnew=" + ispatinentnew + ", user=" + user + "]";
	}
	
	

}
