package com.example.mycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.model.Practice;

@Repository
public interface PracticesRepository extends JpaRepository<Practice, Long> {
}
