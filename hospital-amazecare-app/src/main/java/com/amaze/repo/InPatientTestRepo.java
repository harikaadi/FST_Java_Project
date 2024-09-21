package com.amaze.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amaze.model.InPatientTest;

@Repository
public interface InPatientTestRepo extends JpaRepository<InPatientTest, Integer>{
	
	//select i from InPatientTest i where i.inpatient.id=?1
	
	@Query("select i from InPatientTest i where i.inpatient.id=?1")
	List<InPatientTest> findinpatinettest(int patinetid);
	

}
