package com.example.mycrud.repository;

import com.example.mycrud.model.University;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    @NotNull
    @NonNull
    public Optional<University> findById(Integer id);

    //arreglar esto


    public List<University> findByNameAndEmail(String name, String email);

    List<University> findByLocation(String location);
}
