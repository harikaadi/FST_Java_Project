package com.amaze.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.enums.CommonHealthIssues;
import com.amaze.model.HealthIssue;

@Repository
public interface HealthIssueRepo extends JpaRepository<HealthIssue, Integer> {
	
	//Optional<List<HealthIssue>> optionhealthissue findHealthissuebyissueName(String issueName);
	Optional<HealthIssue> findByIssueName(CommonHealthIssues issueName);

	//void findByIssueName(CommonHealthIssues healthissue);

}
