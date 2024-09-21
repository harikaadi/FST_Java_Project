package com.amaze.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Optional<List<Doctor>> findBySpecialization(String specialization);
    Optional<List<Doctor>> findByAvailable(Boolean available);

}
