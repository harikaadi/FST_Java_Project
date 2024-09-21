package com.amaze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaze.model.Test;

@Repository
public interface Test_InPRepo extends JpaRepository<Test, Integer>{

}
