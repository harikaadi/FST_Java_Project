package com.amaze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amaze.exception.InvalidSpecializationException;
import com.amaze.exception.NoDoctorsAvailableException;
import com.amaze.model.Doctor;
import com.amaze.model.UserInfo;
import com.amaze.repo.DoctorRepository;
import com.amaze.repo.UserRepository;

@Service
public class DoctorService {
	
	@Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Doctor addDoctor(Doctor doctor) {
        // Detach user info from doctor
        UserInfo user = doctor.getUser();
        user.setRole("ROLE_DOCTOR");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save UserInfo first
        user = userRepository.save(user);

        // Attach the saved user back to doctor
        doctor.setUser(user);

        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) throws InvalidSpecializationException {
        Optional<List<Doctor>> optionalDoctors = doctorRepository.findBySpecialization(specialization);
        if (optionalDoctors.isEmpty()) {
            throw new InvalidSpecializationException("No doctors found for specialization: " + specialization);
        }
        return optionalDoctors.get();
    }

    public List<Doctor> getAvailableDoctors() throws NoDoctorsAvailableException {
        Optional<List<Doctor>> optionalDoctors = doctorRepository.findByAvailable(true);
        if (optionalDoctors.isEmpty()) {
            throw new NoDoctorsAvailableException("No available doctors found.");
        }
        return optionalDoctors.get();
    }

}
