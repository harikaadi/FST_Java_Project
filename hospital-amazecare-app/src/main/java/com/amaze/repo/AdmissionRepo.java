package com.amaze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.model.Admission;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Integer>{
	
	

}
