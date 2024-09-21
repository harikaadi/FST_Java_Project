package com.amaze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.model.InpatientTestResult;

@Repository
public interface InpatientTestResultRepo  extends JpaRepository<InpatientTestResult, Integer>{

}
