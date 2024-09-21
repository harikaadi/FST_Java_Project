package com.amaze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.model.Employee;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer>{

}
