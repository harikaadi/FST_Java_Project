package com.amaze.exception;

public class InvalidAdmissionId extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAdmissionId(String meassage) {
		super();
		this.meassage = meassage;
	}

	private String meassage;

	public String getMeassage() {
		return meassage;
	}
	

}
