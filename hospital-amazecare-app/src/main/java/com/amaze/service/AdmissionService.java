package com.amaze.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaze.enums.CommonHealthIssues;
import com.amaze.enums.RoomType;
import com.amaze.exception.InvalidIdException;
import com.amaze.exception.NoRoomsAvailableException;
import com.amaze.model.Admission;
import com.amaze.model.Doctor;
import com.amaze.model.HealthIssue;
import com.amaze.model.InPatient;
import com.amaze.model.Room;
import com.amaze.repo.AdmissionRepo;
import com.amaze.repo.DoctorRepository;
import com.amaze.repo.HealthIssueRepo;
import com.amaze.repo.PatientRepo;
import com.amaze.repo.RoomRepository;

@Service
public class AdmissionService {
	
	@Autowired
	private PatientRepo patientrepo;
	
	
	
	@Autowired
	private HealthIssueRepo healthissuerepo;
	
	@Autowired
	private DoctorRepository doctorepo;
	
	@Autowired
	private RoomRepository roomrepo;
	
	
	@Autowired
	private AdmissionRepo admissionrepo;


	public Admission addAdmission(int patientid, CommonHealthIssues issueName, RoomType roomtype, Admission admission) throws InvalidIdException, NoRoomsAvailableException {
		System.out.println("inside add_admission service");
     //fetch patient by patientID
		 Optional <InPatient> optionpatient = patientrepo.findById(patientid);
		 if(optionpatient.isEmpty()) {
			 throw new InvalidIdException("patientid is invalid");
		     }
		 InPatient patient = optionpatient.get();
		 System.out.println("after patient ");
		 System.out.println(" patient "+patient);
		 
	 //check whather healthissue exsits
		 Optional <HealthIssue> optionhealthissue= healthissuerepo.findByIssueName(issueName);
		 if(optionhealthissue.isEmpty()) {
			 throw new InvalidIdException("healthissue is invalid");
		 }
		 HealthIssue healthisuue = optionhealthissue.get();
		 System.out.println("after healthissue ");
		 System.out.println("after healthissue "+healthisuue);
		 
	 //fetch doctor by healthissue
		Optional<Doctor> optiondoctor = doctorepo.findById(healthisuue.getDoctor().getId());
		Doctor doctor =optiondoctor.get();
		System.out.println("after doctor ");
		 System.out.println("after doctor "+doctor);
		
	// Convert roomTypeStr to RoomType enum
        /*RoomType roomType;
        try {
            roomType = RoomType.valueOf(roomtype);
            System.out.println("inside room conversion ");
   		 System.out.println("room coversion "+roomType);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException("Invalid room type specified.");
        }*/
        
		
	//finding room
		 System.out.println("romm"+roomtype);
		List<Room> roomsavalible = roomrepo.findRoomAvailable(roomtype);
		if(roomsavalible.isEmpty()) {
			throw new NoRoomsAvailableException("No available rooms found for the specified room type.");
		}
		
		// Select the first available room (or implement your logic for room selection)
        Room selectedRoom = roomsavalible.get(0);
        
        //modify booked room details or Mark the room as occupied if necessary
        selectedRoom.setBedsCount(selectedRoom.getBedsCount()-1);  
        
        if(selectedRoom.getBedsCount() == 0) {
        	selectedRoom.setIsAvailable(false);
        }
        
        roomrepo.save(selectedRoom);
        
     // Set details on admission
        admission.setPatient(patient);
        admission.setDoctor(doctor);
        admission.setRoom(selectedRoom);
        admission.setAdmissionDate(LocalDate.now());
        
        

    // Save the admission
        return admissionrepo.save(admission);

		 }
        
	

	/*@Autowired
	public void addAdmission(int patientid, CommonHealthIssues issueName, String roomtype,) throws InvalidIdException {
		
		 Optional <Patient> optionpatient = patientrepo.findById(patientid);
		 if(optionpatient.isEmpty()) {
			 throw new InvalidIdException("patientid is invalid");
		 }
		 Patient patient = optionpatient.get();
		 //patientrepo.save(patient);
		 Admission admission =new Admission();
		 
		 
		 Optional <HealthIssue> optionhealthissue= healthissuerepo.findByIssueName(issueName);
		 if(optionhealthissue.isEmpty()) {
			 throw new InvalidIdException("healthissue is invalid");
		 }
		 
		 
		 
		 
	}*/

}
