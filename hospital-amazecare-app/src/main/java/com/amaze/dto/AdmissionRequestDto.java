package com.amaze.dto;

import com.amaze.enums.RoomType;

public class AdmissionRequestDto {
	
	
	 private RoomType roomType;
	 
	    private String admissionType;
		
		
		public String getAdmissionType() {
			return admissionType;
		}
		public void setAdmissionType(String admissionType) {
			this.admissionType = admissionType;
		}
		public RoomType getRoomType() {
			return roomType;
		}
		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}

}
