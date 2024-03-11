package com.example.mycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

}
